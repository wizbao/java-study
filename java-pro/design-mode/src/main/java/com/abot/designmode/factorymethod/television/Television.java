package com.abot.designmode.factorymethod.television;

import com.abot.designmode.factorymethod.framework.Product;

public class Television extends Product {
    private String name;

     Television(String name) {
        this.name = name;
        System.out.println("制作" + name + "电视机");
    }

    @Override
    public void use() {
        System.out.println("使用" + name + "电视机");
    }
}
