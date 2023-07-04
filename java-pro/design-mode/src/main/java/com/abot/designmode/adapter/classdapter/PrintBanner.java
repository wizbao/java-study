package com.abot.designmode.adapter.classdapter;

/**
 * 适配器
 *
 * @author weibao
 */
public class PrintBanner extends Banner implements Print{
    public PrintBanner(String s) {
        super(s);
    }
    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
