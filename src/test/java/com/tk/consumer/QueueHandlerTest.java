package com.tk.consumer;

import com.tk.RBApplication;
import com.tk.constant.RabbitConstant;
import com.tk.message.MessageStruct;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RBApplication.class)
class QueueHandlerTest {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  /**
   * 测试直接模式发送
   */
  @Test
  public void sendDirect() {
    rabbitTemplate.convertAndSend(RabbitConstant.DIRECT_MODE_QUEUE, new MessageStruct("This is direct message"));
  }
}