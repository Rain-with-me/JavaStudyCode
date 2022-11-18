package com.lu.edu.entity.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class MailForm {
    // 寄件人
    private String from;

    // 收件人
    private List<String> to;

    // 主题
    private String subject;

    // 文本
    private String text;

    // 本地附件路径
    private List<String> attachmentPath;

    // 模板名
    private String templateName;

    // 模板变量
    private Map<String,Object> contextVar;
}