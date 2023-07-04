package com.abot.designmode.adapter.classdapter;

/**
 * 实际情况
 *
 * @author weibao
 */
public class Banner {
    private String string;

    public Banner(String s) {
        this.string = s;
    }

    public void showWithParen(){
        System.out.println("("+string+")");
    }

    public void showWithAster(){
        System.out.println("*"+string+"*");
    }
}
