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

package org.ylzl.eden.common.cache.l1cache;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;

/**
 * 缓存加载器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RequiredArgsConstructor
public class AsyncL1CacheLoader {

	private final L1CacheLoader delegate;

	private final Executor executor;

	/**
	 * 根据 Key 异步加载 Value
	 *
	 * @param key 缓存Key
	 * @param executor 执行器
	 * @return CompletableFuture
	 */
	<K, V> CompletableFuture<V> load(@NonNull K key, @NonNull Executor executor) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				return delegate.load(key);
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new CompletionException(e);
			}
		}, executor);
	}
}
