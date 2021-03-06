package com.sbjpa.service;

import com.sbjpa.dao.UserDao;
import com.sbjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * Created by Administrator on 2019-05-24.
 */
@Service
public class UserRepositoryImpl implements UserDao{

    @Autowired
    EntityManager entityManager;
    @Override
    public void test() {
        User user = entityManager.find(User.class,1);
        System.out.println(user.toString());
    }
}
