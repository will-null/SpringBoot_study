package com.example.service.Impl;

import com.example.Utils.RedisUtil;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    User user;

    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User findById() {
        //String key = "user"+id;
        //System.out.println("key是"+key);
        if(redisUtil.hasKey("2")) {
            user = (User)redisUtil.get("2");
            System.out.println("查询的是缓存");
        }else{
            System.out.println("缓存没有");
            user = userMapper.findById();
            System.out.println("查询的是数据库"+user);
            //System.out.println(redisUtil.set(key,user) ? "插入成功" : "插入失败");
        }
        return user;
    }
}
