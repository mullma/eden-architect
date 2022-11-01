/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.idempotent.core.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.Redisson;
import org.redisson.api.RMapCache;
import org.ylzl.eden.idempotent.core.annotation.Idempotent;
import org.ylzl.eden.spring.framework.aop.util.AspectJAopUtils;
import org.ylzl.eden.spring.framework.web.util.RequestUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 幂等性切面
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RequiredArgsConstructor
@Slf4j
@Aspect
public class IdempotentAspect {

	private static final String RMAPCACHE_KEY = "idempotent";

	private final Redisson redisson;

	@Pointcut("@within(org.ylzl.eden.idempotent.core.annotation.Idempotent) && execution(public * *(..))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		if (method.isAnnotationPresent(Idempotent.class)) {
			Idempotent idempotent = method.getAnnotation(Idempotent.class);

			String key = idempotent.key();
			String resolveKey = StringUtils.isNotBlank(key)?
				AspectJAopUtils.parseSpelExpression(key, joinPoint) : this.generatorDefaultKey(joinPoint);

			RMapCache<String, Object> rMapCache = redisson.getMapCache(RMAPCACHE_KEY);
		}

		Object response;
		try {
			response = joinPoint.proceed();
		} finally {

		}
		return response;
	}

	private String generatorDefaultKey(ProceedingJoinPoint joinPoint) {
		String url = RequestUtils.getRequestURL();
		String argString = Arrays.asList(joinPoint.getArgs()).toString();
		return url + argString;
	}
}
