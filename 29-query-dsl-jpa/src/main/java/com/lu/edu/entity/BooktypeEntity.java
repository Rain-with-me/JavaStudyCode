package com.lu.edu.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 11:14
 **/
@Entity
@Table(name = "booktype", schema = "books", catalog = "")
public class BooktypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tid")
    private int tid;
    @Basic
    @Column(name = "name")
    private String name;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooktypeEntity that = (BooktypeEntity) o;
        return tid == that.tid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, name);
    }
}
