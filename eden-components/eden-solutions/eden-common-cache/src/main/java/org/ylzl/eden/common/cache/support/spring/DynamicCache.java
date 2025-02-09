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

package org.ylzl.eden.common.cache.support.spring;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.ylzl.eden.common.cache.Cache;

import java.util.concurrent.Callable;

/**
 * 动态缓存
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class DynamicCache extends AbstractValueAdaptingCache {

	/** 缓存名称 */
	private final String name;

	/** 缓存接口 */
	private final Cache cache;

	/**
	 * 有参构造函数
	 *
	 * @param allowNullValues 是否允许空值
	 * @param name 缓存名称
	 * @param cache 缓存实例
	 */
	public DynamicCache(boolean allowNullValues, String name, Cache cache) {
		super(allowNullValues);
		this.name = name;
		this.cache = cache;
	}

	@Override
	public @NotNull String getName() {
		return this.name;
	}

	@Override
	public @NotNull Object getNativeCache() {
		return this.cache;
	}

	@Override
	protected Object lookup(@NotNull Object key) {
		return this.cache.get(key);
	}

	@Override
	public ValueWrapper get(@NotNull Object key) {
		return toValueWrapper(this.cache.get(key));
	}

	@Override
	public <T> T get(@NotNull Object key, @NotNull Callable<T> valueLoader) {
		return this.cache.get(key, valueLoader);
	}

	@Override
	public void put(@NotNull Object key, Object value) {
		this.cache.put(key, value);
	}

	@Override
	public ValueWrapper putIfAbsent(@NotNull Object key, Object value) {
		return toValueWrapper(this.cache.putIfAbsent(key, value));
	}

	@Override
	public void evict(@NotNull Object key) {
		this.cache.evict(key);
	}

	@Override
	public void clear() {
		this.cache.clear();
	}
}
