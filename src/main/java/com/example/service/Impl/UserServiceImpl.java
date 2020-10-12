package com.example.service.Impl;


import com.example.Utils.JsonUtility;
import com.example.Utils.RedisUtil;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class UserServiceImpl implements UserService {
    User user;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User findById(String id) throws Exception{
        String key = "user"+id;
        System.out.println("key是"+key);
        if(redisUtil.hasKey(key)) {
            //user = (User)redisUtil.get(key);
            LinkedHashMap linkedHashMap = (LinkedHashMap) redisUtil.get(key);
            String json=JsonUtility.objectToJson(linkedHashMap);
            user =JsonUtility.jsonToObject(json, User.class);
            //String json = new JSONObject().toJSONString(linkedHashMap);
           // user = new JSONObject().parseObject(json, User.class);
            System.out.println("查询的是缓存");
            System.out.println(user);
        }else{
            System.out.println("缓存没有");
            user = userMapper.findById(id);
            System.out.println("查询的是数据库"+user);
            System.out.println(redisUtil.set(key,user) ? "插入成功" : "插入失败");

        }
        return user;
    }
}
