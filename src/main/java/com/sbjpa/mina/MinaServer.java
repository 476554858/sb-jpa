package com.sbjpa.mina;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class MinaServer {

     static int PORT = 7080;
    public static IoAcceptor acceptor = null;

    public static void main(String[] args) throws Exception{

        acceptor = new NioSocketAcceptor();
        //设置编码过滤器
        acceptor.getFilterChain().addLast("code",new ProtocolCodecFilter(
                new TextLineCodecFactory(
                        Charset.forName("UTF-8"),
                        LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue()
                )
        ));

        acceptor.getSessionConfig().setReadBufferSize(1024);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        acceptor.setHandler(new MyHandler());

        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("server == >" + PORT);
    }
}
