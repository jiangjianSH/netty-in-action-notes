package com.jiangjian.learning.netty.chap13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {
    protected void channelRead0(ChannelHandlerContext ctx, LogEvent event) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append(event.getReceived());
        builder.append(" [");
        builder.append(event.getSource().toString());
        builder.append(" ] [");
        builder.append(event.getLogfile());
        builder.append(" ]:");
        builder.append(event.getMsg());
        System.out.println(builder.toString());
    }
}
