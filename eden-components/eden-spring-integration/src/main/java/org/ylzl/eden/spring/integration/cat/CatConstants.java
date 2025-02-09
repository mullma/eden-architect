package org.ylzl.eden.spring.integration.cat;

import lombok.experimental.UtilityClass;

/**
 * CAT 常量定义扩展，需要对齐 CAT 规则
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@UtilityClass
public class CatConstants extends com.dianping.cat.CatConstants {

	// Dubbo
	// 参考：com.dianping.cat.consumer.storage.builder.StorageRPCBuilder
	// 参考：com.dianping.cat.consumer.dependency.DependencyAnalyzer
	public final static String TYPE_PROVIDER = "RPC.Service";
	public final static String TYPE_PROVIDER_APP = TYPE_PROVIDER + ".app";
	public final static String TYPE_PROVIDER_CLIENT = TYPE_PROVIDER + ".client";
	public final static String TYPE_PROVIDER_BIZ_ERROR = TYPE_PROVIDER + ".biz.error";
	public final static String TYPE_PROVIDER_TIMEOUT_ERROR = TYPE_PROVIDER + ".timeout.error";
	public final static String TYPE_PROVIDER_REMOTING_ERROR = TYPE_PROVIDER + ".remoting.error";
	public final static String TYPE_CONSUMER = "RPC.Call";
	public final static String TYPE_CONSUMER_APP = TYPE_CONSUMER + ".app";
	public final static String TYPE_CONSUMER_SERVER = TYPE_CONSUMER + ".server";
	public final static String TYPE_CONSUMER_PORT = TYPE_CONSUMER + ".port";
	public final static String TYPE_CONSUMER_BIZ_ERROR = TYPE_PROVIDER + ".biz.error";
	public final static String TYPE_CONSUMER_TIMEOUT_ERROR = TYPE_PROVIDER + ".timeout.error";
	public final static String TYPE_CONSUMER_REMOTING_ERROR = TYPE_PROVIDER + ".remoting.error";

	// SQL
	// 参考 com.dianping.cat.consumer.storage.builder.StorageSQLBuilder
	public static final String TYPE_SQL = com.dianping.cat.CatConstants.TYPE_SQL;
	public static final String TYPE_SQL_DATABASE = "SQL.Database";
	public static final String TYPE_SQL_METHOD = "SQL.Method";

	// Cache
	// 参考 com.dianping.cat.consumer.storage.builder.StorageCacheBuilder
	public static final String TYPE_CACHE = "Cache";
	public static final String TYPE_CACHE_SERVER = TYPE_CACHE + ".server";
	public static final String TYPE_CACHE_REDIS = TYPE_CACHE + ".Redis";
	public static final String TYPE_CACHE_CAFFEINE = TYPE_CACHE + ".Caffeine";
	public static final String TYPE_CACHE_GUAVA = TYPE_CACHE + ".Guava";

	// Http
	// 参考 com.dianping.cat.consumer.matrix.MessageAnalyzer
	// 参考 com.dianping.cat.consumer.dependency.DependencyAnalyzer
	public static final String TYPE_URL = com.dianping.cat.CatConstants.TYPE_URL;
	public static final String TYPE_URL_SERVER = TYPE_URL + ".Server";
	public static final String TYPE_URL_METHOD = TYPE_URL + ".Method";
	public static final String TYPE_URL_HEADER = TYPE_URL + ".Header";
	public static final String TYPE_URL_BODY = TYPE_URL + ".Body";
	public static final String TYPE_URL_FORWARD = com.dianping.cat.CatConstants.TYPE_URL_FORWARD;
	public static final String TYPE_URL_FORWARD_METHOD = TYPE_URL_FORWARD + ".Method";
	public static final String TYPE_URL_FORWARD_HEADER = TYPE_URL_FORWARD + ".Header";
	public static final String TYPE_URL_FORWARD_BODY = TYPE_URL_FORWARD + ".Body";
	public final static String TYPE_URL_BIZ_ERROR = TYPE_PROVIDER + ".biz.error";
	public final static String TYPE_URL_TIMEOUT_ERROR = TYPE_PROVIDER + ".timeout.error";
	public final static String TYPE_URL_REDIRECTION_ERROR = TYPE_PROVIDER + ".redirection.error";
	public final static String TYPE_URL_CLIENT_ERROR = TYPE_PROVIDER + ".client.error";
	public final static String TYPE_URL_SERVER_ERROR = TYPE_PROVIDER + ".server.error";

	// Trace
	// 自定义链路传递参数
	public static final String X_FORWARDED_FOR = "x-forwarded-for";
	public static final String X_CAT_TRACE_MODE = "x-cat-trace-mode";
	public static final String X_CAT_SOURCE = "x-cat-source";
	public static final String X_CAT_ID = "x-cat-id";
	public static final String X_CAT_CHILD_ID = "x-cat-child-id";
	public static final String X_CAT_PARENT_ID = "x-cat-parent-id";
	public static final String X_CAT_SERVER = "x-cat-server";

	// Rewrite CatFilter
	public static final String CAT_STATE = com.dianping.cat.CatConstants.CAT_STATE;
	public static final String CAT_PAGE_URI = com.dianping.cat.CatConstants.CAT_PAGE_URI;
	public static final String CAT_PAGE_TYPE = com.dianping.cat.CatConstants.CAT_PAGE_TYPE;
}
