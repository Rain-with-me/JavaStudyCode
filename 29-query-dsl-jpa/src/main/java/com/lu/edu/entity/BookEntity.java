package com.lu.edu.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
@Entity
@Builder
@Table(name = "book", schema = "books", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bid")
    private int bid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "card")
    private String card;
    @Basic
    @Column(name = "autho")
    private String autho;
    @Basic
    @Column(name = "num")
    private int num;
    @Basic
    @Column(name = "press")
    private String press;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "times")
    private Integer times;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bid == that.bid && num == that.num && Objects.equals(name, that.name) && Objects.equals(card, that.card) && Objects.equals(autho, that.autho) && Objects.equals(press, that.press) && Objects.equals(type, that.type) && Objects.equals(times, that.times);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, name, card, autho, num, press, type, times);
    }
}
