package com.lu.edu.service.impl;

import com.lu.edu.entity.domain.MailForm;
import com.lu.edu.service.MailService;
import com.lu.edu.utils.exception.DiyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private MailProperties mailProperties;

//    thymeleaf模板
    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendSimpleMail(MailForm form) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(mailProperties.getUsername());

            List<String> to = form.getTo();
            String[] toUsers = form.getTo().toArray(new String[to.size()]);
            mailMessage.setTo(toUsers);
            mailMessage.setSubject(form.getSubject());
            mailMessage.setText(form.getText());

            System.out.println(mailProperties.getUsername()+"========"+to);
            mailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
            throw new DiyException(500,"邮件发送失败");
        }
    }

    @Override
    public void sendHtmlMail(MailForm form) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(mailProperties.getUsername());
            List<String> to = form.getTo();
            String[] toUsers = form.getTo().toArray(new String[to.size()]);
            messageHelper.setTo(toUsers);
            messageHelper.setSubject(form.getSubject());
            messageHelper.setText(form.getText(), true);

            // 本地附件
            if (form.getAttachmentPath() != null) {
                List<String> pathList = form.getAttachmentPath();
                for (String attachmentPath : pathList) {
                    File file = new File(attachmentPath);
                    if (file.exists()) {
                        String fileName = file.getName();
                        FileSystemResource fsr = new FileSystemResource(file);
                        messageHelper.addAttachment(fileName, fsr);
                    }
                }
            }

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
            throw new DiyException(500,"邮件发送失败");
        }
    }

    @Override
    public void sendTemplateMail(MailForm form) {
        try {
            Context context = new Context();
//            context.setLocale(Locale.CHINA);
            context.setVariables(form.getContextVar());
            String templateMail = templateEngine.process(form.getTemplateName(), context);
            form.setText(templateMail);
            sendHtmlMail(form);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
            throw new DiyException(500,"邮件发送失败");
        }
    }
}