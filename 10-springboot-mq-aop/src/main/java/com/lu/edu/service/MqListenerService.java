package com.lu.edu.service;

import com.lu.edu.entity.domain.MailForm;
import com.lu.edu.entity.vo.OpLogVO;
import com.lu.edu.utils.exception.DiyException;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class MqListenerService {

    @Autowired
    private MailService mailService;

    /** 
     * @Description: 消费邮件
     * @Author: 雨同我
     * @DateTime: 2022/11/18 11:26
    */
    @RabbitListener(queues = "${mq.config.queue}")
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
    
    /** 
     * @Description: 消费aop日志
     * @Author: 雨同我
     * @DateTime: 2022/11/18 11:26
    */
    @RabbitListener(queues = "${mq.config.log}")
    public void saveOplogMessage(Message message, Channel channel, OpLogVO opLogVO) throws IOException {
//        TODO 这里持久化就自己搞了，里面的时间建议使用mybatisplus里面的自动填充
        System.out.println(opLogVO);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}