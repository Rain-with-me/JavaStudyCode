package com.lu.edu;

import com.lu.edu.entity.ScyTeacher;
import com.lu.edu.service.ScyTeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class InvigilateApplicationTests {

    @Resource
    private JavaMailSender javaMailSender;

    @Autowired
    private ScyTeacherService scyTeacherService;

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

    @Test
    void mybatis() {
        List<ScyTeacher> scy_teacher = scyTeacherService.selectAll("scy_teacher");
        System.out.println(scy_teacher);
    }

}
