package com.sbjpa.controller;

import com.sbjpa.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
/*

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User s  = userRepository.save(user);
        return s;   
    }

    @GetMapping("/testSave")
    public User testSave(){
        User user = new User();
        user.setId(1);
        user.setEmail("aaaaaa");
        User s = userRepository.save(user);
        return s;
    }
*/
    @ApiOperation(value = "登录接口",httpMethod = "POST",response = Map.class,notes = "接口发布说明")
    @CrossOrigin
    @RequestMapping("/login")//@RequestParam("username")String username,@RequestParam("password")String password
    public Map<String,Object> loginTest(@RequestParam("username")String username,@RequestParam("password")String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if("admin".equals(username)){
            map.put("msg","success");
        }else{
            map.put("msg","fail");
        }
        return map;
    }

    @ApiOperation(value = "登录接口",httpMethod = "POST",response = List.class,notes = "接口发布说明")
    @CrossOrigin
    @RequestMapping("/getuserlist")
    public List<Map<String,Object>> getuserlist(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=1;i<=5;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id",i);
            map.put("username","name"+i);
            map.put("realname","张"+i);
            map.put("idType","2222121"+i);
            list.add(map);
        }
        return list;
    }

}
