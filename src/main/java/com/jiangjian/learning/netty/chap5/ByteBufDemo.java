package com.jiangjian.learning.netty.chap5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

public class ByteBufDemo {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println("Capacity: " + byteBuf.capacity());
        byteBuf.writeBoolean(true);
        byteBuf.writeBoolean(true);
        byteBuf.writeBoolean(true);
        byteBuf.writeFloat(1.9f);
        System.out.println(byteBuf.readBoolean());

        System.out.println(byteBuf.readableBytes());
        System.out.println(byteBuf.writableBytes());

        System.out.println(byteBuf.discardReadBytes());
        System.out.println(byteBuf.readableBytes());
        System.out.println(byteBuf.writableBytes());
        System.out.println(ByteBufUtil.hexDump(byteBuf));
    }
}
