package com.abot.designmode.factorymethod;

import com.abot.designmode.factorymethod.framework.Factory;
import com.abot.designmode.factorymethod.framework.Product;
import com.abot.designmode.factorymethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product p1 = factory.create("jay");
        Product p2 = factory.create("jony");
        p1.use();
        p1.use();
    }
}
