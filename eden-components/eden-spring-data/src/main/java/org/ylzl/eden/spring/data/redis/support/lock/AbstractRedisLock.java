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

package org.ylzl.eden.spring.data.redis.support.lock;

/**
 * 抽象 Redis 锁
 *
 * @author gyl
 * @since 2.4.x
 */
public abstract class AbstractRedisLock implements RedisLock {

  @Override
  public boolean lock(String key) {
    return lock(key, DEFAULT_SECONDS_TO_EXPIRE, RETRY_TIMES, DEFAULT_SLEEP_MILLIS);
  }

  @Override
  public boolean lock(String key, int retryTimes, long sleepMillis) {
    return lock(key, DEFAULT_SECONDS_TO_EXPIRE, retryTimes, sleepMillis);
  }

  @Override
  public boolean lock(String key, int secondsToExpire) {
    return lock(key, secondsToExpire, RETRY_TIMES, DEFAULT_SLEEP_MILLIS);
  }

  @Override
  public boolean lock(String key, int secondsToExpire, int retryTimes) {
    return lock(key, secondsToExpire, retryTimes, DEFAULT_SLEEP_MILLIS);
  }
}
