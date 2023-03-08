package com.tk.consumer;

import com.rabbitmq.client.Channel;
import com.tk.constant.RabbitConstant;
import com.tk.message.MessageStruct;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
//配置监听的哪一个队列，同时在没有queue和exchange的情况下会去创建并建立绑定关系
@RabbitListener(bindings = @QueueBinding(
		value = @Queue(value = RabbitConstant.DIRECT_MODE_QUEUE,durable = "true"),
		exchange = @Exchange(name=RabbitConstant.DIRECT_EXCHANGE,durable = "true",type = "direct"),
		key = ""
	)
)
@RabbitListener(queues = RabbitConstant.DIRECT_MODE_QUEUE)
@Component
public class DirectQueueHandler {
	@RabbitHandler
	public void directHandlerManualAck(MessageStruct messageStruct, Message message, Channel channel) {
		// 如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
		final long deliveryTag = message.getMessageProperties().getDeliveryTag();
		try {
			log.info("直接队列1，手动ACK，接收消息：{}", messageStruct);
			Thread.sleep(2000);
			// 通知 MQ 消息已被成功消费,可以ACK了
			channel.basicAck(deliveryTag, false);
		} catch (IOException e) {
			try {
				// 处理失败,重新压入MQ
				channel.basicRecover();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
