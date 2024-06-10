package com.lu.edu.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
@Entity
@Table(name = "problem", schema = "books", catalog = "")
public class ProblemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pid")
    private int pid;
    @Basic
    @Column(name = "aid")
    private Integer aid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "page")
    private String page;
    @Basic
    @Column(name = "body")
    private String body;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "status")
    private String status;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemEntity that = (ProblemEntity) o;
        return pid == that.pid && Objects.equals(aid, that.aid) && Objects.equals(name, that.name) && Objects.equals(page, that.page) && Objects.equals(body, that.body) && Objects.equals(phone, that.phone) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, aid, name, page, body, phone, status);
    }
}
