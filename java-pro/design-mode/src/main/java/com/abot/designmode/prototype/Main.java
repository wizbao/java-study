package com.abot.designmode.prototype;

import com.abot.designmode.prototype.framework.Manager;
import com.abot.designmode.prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message",upen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);
        // 生成
        Product p1 = manager.create("strong message");
        Product p2 = manager.create("warning box");
        Product p3 = manager.create("slash box");
        p1.use("hello");
        p2.use("hello");
        p3.use("hello");
    }
}
