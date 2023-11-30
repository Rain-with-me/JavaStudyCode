package com.lu.edu.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
@Entity
@Table(name = "history", schema = "books", catalog = "")
public class HistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hid")
    private int hid;
    @Basic
    @Column(name = "aid")
    private Integer aid;
    @Basic
    @Column(name = "bid")
    private Integer bid;
    @Basic
    @Column(name = "card")
    private Integer card;
    @Basic
    @Column(name = "bookname")
    private String bookname;
    @Basic
    @Column(name = "adminname")
    private String adminname;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "begintime")
    private String begintime;
    @Basic
    @Column(name = "endtime")
    private String endtime;
    @Basic
    @Column(name = "status")
    private Integer status;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return hid == that.hid && Objects.equals(aid, that.aid) && Objects.equals(bid, that.bid) && Objects.equals(card, that.card) && Objects.equals(bookname, that.bookname) && Objects.equals(adminname, that.adminname) && Objects.equals(username, that.username) && Objects.equals(begintime, that.begintime) && Objects.equals(endtime, that.endtime) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, aid, bid, card, bookname, adminname, username, begintime, endtime, status);
    }
}
