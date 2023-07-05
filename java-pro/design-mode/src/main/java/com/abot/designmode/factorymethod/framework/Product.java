package com.abot.designmode.factorymethod.framework;

public abstract class Product {
    public abstract void use();
    public   Product(String name){
        System.out.println(name);
    }
    public Product(){
        System.out.println("无参构造方法");
    }
}
