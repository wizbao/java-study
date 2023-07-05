package com.abot.designmode.factorymethod.television;

import com.abot.designmode.factorymethod.framework.Factory;
import com.abot.designmode.factorymethod.framework.Product;

public class TelevisionFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new Television(owner);
    }

    @Override
    protected void registerProduct(Product product) {

    }
}
