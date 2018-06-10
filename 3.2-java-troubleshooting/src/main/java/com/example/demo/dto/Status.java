package com.example.demo.dto;

import java.io.Serializable;

public class Status implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private int value;

    public Status() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}