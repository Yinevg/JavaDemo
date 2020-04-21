package com.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by Yinevg on 2020/4/21
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private static final String QUERY_TIME_ORDER = "QUERY TIME ORDER";
    private static final String BAD_REQUEST = "BAD REQUEST";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String request = (String) msg;
        String response = null;
        response = QUERY_TIME_ORDER.equals(request) ?
                new Date(System.currentTimeMillis()).toString() :
                BAD_REQUEST;
        response += System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(response.getBytes());
        ctx.writeAndFlush(resp);
    }
}
