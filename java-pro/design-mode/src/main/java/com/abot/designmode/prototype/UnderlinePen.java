package com.abot.designmode.prototype;

import com.abot.designmode.prototype.framework.Product;

public class UnderlinePen implements Product{
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }
    @Override
    public void use(String s) {
        int len = s.length();
        System.out.println("\""+s+"\"");
        System.out.print(" ");
        for (int i = 0; i < len; i++) {
            System.out.print(ulChar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
}
