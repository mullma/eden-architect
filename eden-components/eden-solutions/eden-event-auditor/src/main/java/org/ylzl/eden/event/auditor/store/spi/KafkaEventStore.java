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

package org.ylzl.eden.event.auditor.store.spi;

import org.ylzl.eden.event.auditor.model.AuditingEvent;
import org.ylzl.eden.event.auditor.store.EventStore;

import java.util.List;

/**
 * 基于 Kafka 存储审计事件
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class KafkaEventStore implements EventStore {

	/**
	 * 存储审计事件列表
	 *
	 * @param events 审计事件列表
	 */
	@Override
	public void store(List<AuditingEvent> events) {

	}
}
