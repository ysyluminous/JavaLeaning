package com.yaosiyuan.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 消息队列发送者
 * @Author:
 * @CreateTime:
 */
@Service
public class Producer {
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendQueue(String exchange_key, String queue_key, Object object) {
		// convertAndSend 将Java对象转换为消息发送至匹配key的交换机中Exchange
		amqpTemplate.convertAndSend(exchange_key, queue_key, object);
	}
}
