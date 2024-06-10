package com.lu.edu;

import com.lu.edu.entity.domain.MailForm;
import com.lu.edu.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class InvigilateApplicationTests {

    @Resource
    private JavaMailSender javaMailSender;

    @Autowired
    private MailService mailService;

    /** 
     * @Description: 发送模板邮件
     * @Author: 雨同我
     * @DateTime: 2022/11/12 10:46
    */
    @Test
    void test(){
        MailForm form = new MailForm();
        form.setTo(Arrays.asList("2168702791@qq.com"));
        form.setSubject("Test simple mail");
        form.setText("Hello this is test mail from java");
        form.setContextVar(new HashMap<String, Object>(){{
            put("code","697059");
        }});
        form.setTemplateName("emailTemplate");
        mailService.sendTemplateMail(form);
    }
/**
 * @Description: 发送普通邮件
 * @Author: 雨同我
 * @DateTime: 2022/11/12 10:48
*/

    @Test
    void contextLoads() {
        // 简单邮件类
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 寄件人，默认是配置的username
        mailMessage.setFrom("2110314696@qq.com");
        // 收件人，支持多个收件人
        mailMessage.setTo("2168702791@qq.com");
        // 邮件主题
        mailMessage.setSubject("Test simple mail");
        // 邮件的文本信息
        mailMessage.setText("Hello this is test mail from java");

        // 发送邮件
        javaMailSender.send(mailMessage);
    }

}
