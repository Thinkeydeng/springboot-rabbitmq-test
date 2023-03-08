package com.tk.constant;

/**
 * RabbitMQ常量池
 */
public interface RabbitConstant {

	/**
	 * 直接模式交换机
	 */
	String DIRECT_EXCHANGE = "direct-exchange";
	/**
	 * 直接模式队列
	 */
	String DIRECT_MODE_QUEUE = "direct.queue.test";

	/**
	 * 队列2
	 */
	String QUEUE_TWO = "queue.2";

	/**
	 * 队列3
	 */
	String QUEUE_THREE = "3.queue";

	/**
	 * 分列模式
	 */
	String FANOUT_MODE_QUEUE = "fanout.mode";

	/**
	 * 主题模式
	 */
	String TOPIC_MODE_QUEUE = "topic.mode";

	/**
	 * 路由1
	 */
	String TOPIC_ROUTING_KEY_ONE = "queue.#";

	/**
	 * 路由2
	 */
	String TOPIC_ROUTING_KEY_TWO = "*.queue";

	/**
	 * 路由3
	 */
	String TOPIC_ROUTING_KEY_THREE = "3.queue";

	/**
	 * 延迟队列
	 */
	String DELAY_QUEUE = "delay.queue";

	/**
	 * 延迟队列交换器
	 */
	String DELAY_MODE_QUEUE = "delay.mode";
}
