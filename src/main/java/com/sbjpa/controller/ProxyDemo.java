package com.sbjpa.controller;

import com.sbjpa.repository.UserRepository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    UserRepository userRepository;

    public ProxyDemo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserProxy(){
        ClassLoader loader = userRepository.getClass().getClassLoader();
        Class[] interfaces = new Class[]{UserRepository.class};

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = method.invoke(proxy,args);
                return result;
            }
        };

        UserRepository proxy = (UserRepository)Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
