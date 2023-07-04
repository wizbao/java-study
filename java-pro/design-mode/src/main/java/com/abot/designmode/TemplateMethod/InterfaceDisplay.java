package com.abot.designmode.TemplateMethod;

public interface InterfaceDisplay {
    void open();
    void close();
    void print();

   default void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
