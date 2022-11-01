package org.ylzl.eden.spring.framework.aop.util;

import lombok.experimental.UtilityClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.ylzl.eden.spring.framework.error.util.AssertEnhancer;
import org.ylzl.eden.spring.framework.error.util.MessageFormatUtils;
import org.ylzl.eden.spring.framework.expression.util.SpelExpressionUtils;

import java.lang.reflect.Method;

/**
 * AspectJ 工具
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@UtilityClass
public class AspectJAopUtils extends org.springframework.aop.aspectj.AspectJAopUtils {

	/**
	 * 从切点获取 Method
	 *
	 * @param joinPoint
	 * @return
	 */
	public static Method getMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		if (method.getDeclaringClass().isInterface()) {
			try {
				method = joinPoint.getTarget().getClass().getDeclaredMethod(joinPoint.getSignature().getName(),
					method.getParameterTypes());
			} catch (SecurityException | NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		}
		return method;
	}

	/**
	 * 解析 Spel 表达式
	 *
	 * @param expressionString
	 * @param joinPoint
	 * @return
	 */
	public static String parseSpelExpression(String expressionString, JoinPoint joinPoint) {
		Object[] arguments = joinPoint.getArgs();
		Method method = getMethod(joinPoint);
		String resolveValue = SpelExpressionUtils.parse(expressionString, method, arguments);
		AssertEnhancer.notNull(resolveValue, MessageFormatUtils.format("Spel expression is invalid: {}",
			expressionString));
		return resolveValue;
	}
}
