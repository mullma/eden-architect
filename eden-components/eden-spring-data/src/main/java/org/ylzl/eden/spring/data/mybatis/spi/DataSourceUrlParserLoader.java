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

package org.ylzl.eden.spring.data.mybatis.spi;

import org.ylzl.eden.commons.lang.StringUtils;
import org.ylzl.eden.extension.ExtensionLoader;

import javax.sql.DataSource;
import java.util.Set;

/**
 * 数据源地址解释器支持类
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class DataSourceUrlParserLoader {

	public static final String UNKNOWN_URL = "jdbc:database://host:port/unknown_db";

	private static final String DS_CLASS_NAME = "com.baomidou.dynamic.datasource.DynamicRoutingDataSource";

	public static String parse(DataSource dataSource) {
		if (DS_CLASS_NAME.equalsIgnoreCase(dataSource.getClass().getName())) {
			dataSource = ((com.baomidou.dynamic.datasource.DynamicRoutingDataSource) dataSource).determineDataSource();
			if (dataSource instanceof com.baomidou.dynamic.datasource.ds.ItemDataSource) {
				dataSource = ((com.baomidou.dynamic.datasource.ds.ItemDataSource) dataSource).getRealDataSource();
			}
		}

		ExtensionLoader<DataSourceUrlParser> extensionLoader = ExtensionLoader.getExtensionLoader(DataSourceUrlParser.class);
		Set<String> extensions = extensionLoader.getSupportedExtensions();
		for (String extension : extensions) {
			DataSourceUrlParser resolver = extensionLoader.getExtension(extension);
			String url = resolver.getDataSourceUrl(dataSource);
			if (StringUtils.isNotEmpty(url)) {
				return url;
			}
		}
		return UNKNOWN_URL;
	}
}
