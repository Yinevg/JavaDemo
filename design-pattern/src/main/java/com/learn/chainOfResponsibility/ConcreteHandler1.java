package com.learn.chainOfResponsibility;

/**
 * Created by Yinevg on 2019/10/8
 */
public class ConcreteHandler1 extends Handler {

    // 定义自己的处理级别
    @Override
    protected Level getHandlerLevel() {
        // 设置自己的处理级别
        return null;
    }

    // 定义自己的处理逻辑
    @Override
    protected Response echo(Request request) {
        // 设置自己的处理级别
        return null;
    }
}
