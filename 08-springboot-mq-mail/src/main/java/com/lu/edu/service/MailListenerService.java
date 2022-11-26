package com.lu.edu.service;

import com.lu.edu.entity.domain.MailForm;
import com.lu.edu.entity.dto.UserForm;
import com.lu.edu.utils.exception.DiyException;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MailListenerService {

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "${mq.queue}")
    public void sendRegisterMail(Message message, Channel channel, MailForm mailForm) throws IOException {
        try {

            mailService.sendTemplateMail(mailForm);
//            mailService.sendSimpleMail(mailForm);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("邮件发送成功");
        } catch (IOException e) {
            log.error("邮件发送失败", e.getMessage());
            // 回复消息处理失败，并重新入队 1是单个的2是多个消息
//             channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            throw new DiyException(500,"邮件发送失败");
        }
    }
}