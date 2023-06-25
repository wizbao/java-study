package com.abot.designmode.iterator;

import lombok.ToString;

/**
 * 书籍
 * @author weibao
 */
@ToString
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
