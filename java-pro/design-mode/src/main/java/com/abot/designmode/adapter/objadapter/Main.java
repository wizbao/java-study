package com.abot.designmode.adapter.objadapter;

/**
 * @author weibao
 */
public class Main {
    public static void main(String[] args) {
        Print printBanner = new PrintBanner("hello");
        printBanner.printWeak();
        printBanner.printStrong();
    }
}
