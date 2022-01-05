//package com.ebsco.serviceimpl;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.ebsco.service.RabbitMQSender;
//
//@Service
//public class RabbitMQSenderServiceImpl implements RabbitMQSender {
//
//  private AmqpTemplate rabbitTemplate;
//
//  private String exchange;
//  private String routingKey;
//
//  public RabbitMQSenderServiceImpl(AmqpTemplate rabbitTemplate,
//    @Value("${rabbitmq.exchange}") String exchange,
//    @Value("${rabbitmq.routingkey}") String routingkey) {
//    this.rabbitTemplate = rabbitTemplate;
//    this.exchange = exchange;
//    this.routingKey = routingkey;
//  }
//
//  @Override
//  public <T> void send(T t) {
//    rabbitTemplate.convertAndSend(exchange, routingKey, t);
//
//  }
//
//}
