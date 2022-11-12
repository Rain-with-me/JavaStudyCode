package com.lu.edu.controller;

import com.lu.edu.entity.domain.MailForm;
import com.lu.edu.entity.dto.UserForm;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

@RestController
public class RegisterController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.exchange}")
    private String MAIL_REGISTER_EXCHANGE;
    @Value("${mq.router-key}")
    private String MAIL_REGISTER_ROUTING_KEY;

    /**
     * 模拟注册，测试消息队列和邮件发送
     */
    @PostMapping("/register")
    public CommonResult mockRegister(@RequestBody UserForm form) {

        MailForm mailForm = new MailForm();
        mailForm.setSubject("Test simple mail");
        mailForm.setText("Hello this is test mail from java");
        mailForm.setTo(Arrays.asList(form.getEmail()));

        mailForm.setContextVar(new HashMap<String, Object>(){{
            put("code","697059");
        }});
        mailForm.setTemplateName("emailTemplate");


        // 邮件通知
        rabbitTemplate.convertAndSend(MAIL_REGISTER_EXCHANGE,MAIL_REGISTER_ROUTING_KEY,mailForm);

        // TODO 其他操作
        return CommonResult.success("注册成功,注册信息将邮件通知");
    }
}