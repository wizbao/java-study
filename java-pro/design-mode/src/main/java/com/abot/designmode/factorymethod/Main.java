package com.abot.designmode.factorymethod;

import com.abot.designmode.factorymethod.framework.Factory;
import com.abot.designmode.factorymethod.framework.Product;
import com.abot.designmode.factorymethod.idcard.IDCardFactory;
import com.abot.designmode.factorymethod.television.TelevisionFactory;

public class Main {
    public static void main(String[] args) {
        Factory idCardFactory = new IDCardFactory();
        Product p1 = idCardFactory.create("jay");
        Product p2 = idCardFactory.create("jony");
        p1.use();
        p1.use();
        System.out.println("==========================");
        Factory televisionFactory = new TelevisionFactory();
        Product p3 = televisionFactory.create("小米");
        Product p4 = televisionFactory.create("华为");
        p3.use();
        p4.use();
    }
}
