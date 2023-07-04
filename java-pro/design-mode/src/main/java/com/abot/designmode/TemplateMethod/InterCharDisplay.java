package com.abot.designmode.TemplateMethod;

public class InterCharDisplay implements InterfaceDisplay{
    private char ch;

    public InterCharDisplay(char ch) {
        this.ch = ch;
    }
    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
