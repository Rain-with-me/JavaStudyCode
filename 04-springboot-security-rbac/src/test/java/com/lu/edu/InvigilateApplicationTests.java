package com.lu.edu;

import com.lu.edu.dao.entity.User;
import com.lu.edu.mapper.UserMapper;
import com.lu.edu.utils.result.CommonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootTest
class InvigilateApplicationTests {

//    @Resource
//    private JavaMailSender javaMailSender;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAllUser() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

//    @Test
//    void contextLoads() {
//        // 简单邮件类
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        // 寄件人，默认是配置的username
//        mailMessage.setFrom("2110314696@qq.com");
//        // 收件人，支持多个收件人
//        mailMessage.setTo("2168702791@qq.com");
//        // 邮件主题
//        mailMessage.setSubject("Test simple mail");
//        // 邮件的文本信息
//        mailMessage.setText("Hello this is test mail from java");
//
//        // 发送邮件
//        javaMailSender.send(mailMessage);
//    }

}
