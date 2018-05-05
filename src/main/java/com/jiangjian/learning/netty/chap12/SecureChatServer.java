package com.jiangjian.learning.netty.chap12;

import io.netty.channel.ChannelFuture;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;

public class SecureChatServer extends ChatServer{
    private final SslContext context;

    public SecureChatServer(SslContext context) {
        this.context = context;
    }

    public static void main(String[] args) throws CertificateException, SSLException {
        SelfSignedCertificate cert = new SelfSignedCertificate();
        SslContext context = SslContext.newServerContext(cert.certificate(), cert.privateKey());
        final SecureChatServer secureChatServer = new SecureChatServer(context);
        ChannelFuture future = secureChatServer.start(new InetSocketAddress(9000));
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                secureChatServer.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
