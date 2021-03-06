package com.sbjpa.service;

import com.sbjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019-05-23.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void updateUser(String lastName,Integer id){
        userRepository.updateUser(lastName,id);
    }
}
