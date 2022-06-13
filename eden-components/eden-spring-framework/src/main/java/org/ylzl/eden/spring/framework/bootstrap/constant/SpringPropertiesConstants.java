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

package org.ylzl.eden.spring.framework.bootstrap.constant;

import lombok.experimental.UtilityClass;

/**
 * Spring Properties 常量定义
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@UtilityClass
public final class SpringPropertiesConstants {

	/**
	 * Spring Boot 读取应用程序名称
	 */
	public static final String SPRING_APPLICATION_NAME = "spring.application.name";

	/**
	 * Spring Boot 读取应用程序名称
	 *
	 * @see org.springframework.boot.context.ContextIdApplicationContextInitializer
	 */
	public static final String NAME_PATTERN =
		"${spring.application.name:${vcap.application.name:${spring.config.name:application}}}";

	/**
	 * Spring Boot 读取应用程序启动端口
	 */
	public static final String PORT_PATTERN = "${server.port}";

	/**
	 * Spring Boot 读取应用程序索引
	 *
	 * @see org.springframework.boot.context.ContextIdApplicationContextInitializer
	 */
	public static final String INDEX_PATTERN =
		"${vcap.application.instance_index:${spring.application.index:${server.port:${PORT:null}}}}";
}
