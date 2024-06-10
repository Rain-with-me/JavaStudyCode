package com.lu.edu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
@Entity
@Table(name = "admin", schema = "books", catalog = "")
@IdClass(AdminEntityPK.class)
public class AdminEntity {
//    这个是主键配置
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "aid")
    private int aid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "times")
    private Integer times;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "lend_num")
    private Integer lendNum;
    @Basic
    @Column(name = "max_num")
    private Integer maxNum;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLendNum() {
        return lendNum;
    }

    public void setLendNum(Integer lendNum) {
        this.lendNum = lendNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return aid == that.aid && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(times, that.times) && Objects.equals(status, that.status) && Objects.equals(lendNum, that.lendNum) && Objects.equals(maxNum, that.maxNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, username, name, password, email, phone, times, status, lendNum, maxNum);
    }
}
