package com.lu.edu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
public class AdminEntityPK implements Serializable {
    @Column(name = "aid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @Column(name = "username")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntityPK that = (AdminEntityPK) o;
        return aid == that.aid && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, username);
    }
}
