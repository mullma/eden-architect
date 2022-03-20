package org.ylzl.eden.spring.integration.messagequeue.consumer;

import java.util.List;

/**
 * 消息监听器接口
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public interface MessageListener {

	/**
	 * 消费消息
	 *
	 * @param messages
	 */
	void consume(List<String> messages, Acknowledgement ack);
}
