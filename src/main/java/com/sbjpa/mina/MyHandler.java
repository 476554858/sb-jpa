package com.sbjpa.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * Created by Administrator on 2019-06-03.
 */
public class MyHandler extends IoHandlerAdapter{
    public MyHandler() {
        super();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
//        super.messageReceived(session, message);
        String msg = (String)message;
        System.out.println("服务端接收到数据："+msg);
        Date date = new Date();
        session.write(date);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }
}
