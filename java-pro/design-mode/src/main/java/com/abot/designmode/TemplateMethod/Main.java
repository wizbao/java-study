package com.abot.designmode.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        InterfaceDisplay ch = new InterCharDisplay('d');
        AbstractDisplay str = new StringDisplay("hello,world!");
        ch.display();
        str.display();
    }
}
