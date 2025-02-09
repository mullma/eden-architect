/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.distributed.uid.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.Map;

/**
 * 号段生成器配置
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@EqualsAndHashCode
@ToString
@Setter
@Getter
public class SegmentGeneratorConfig {

	private boolean enabled = false;

	private String type = "leaf";

	/** 租户 */
	private String tenant = "default";

	/** 最大步长，默认限制为 1_000_000*/
	private int maxStep = 1_000_000;

	/** 一个号段的维持时间，默认为15分钟 */
	private long segmentTtl = 15 * 60 * 1000L;

	private final Liquibase liquibase = new Liquibase();

	@EqualsAndHashCode
	@ToString
	@Setter
	@Getter
	public static class Liquibase {

		private String changeLog = "classpath:/db/changelog/leaf.changelog-master.yaml";

		private boolean clearChecksums;

		private String contexts;

		private String defaultSchema;

		private String liquibaseSchema;

		private String liquibaseTablespace;

		private String databaseChangeLogTable = "DATABASECHANGELOG";

		private String databaseChangeLogLockTable = "DATABASECHANGELOGLOCK";

		private boolean dropFirst;

		private boolean enabled = true;

		private String user;

		private String password;

		private String driverClassName;

		private String url;

		private String labels;

		private Map<String, String> parameters;

		private File rollbackFile;

		private boolean testRollbackOnUpdate;

		private String tag;
	}
}
