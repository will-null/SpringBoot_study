package com.example.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    //判断是否存在key
    public boolean hasKey(String key) {

        return redisTemplate.hasKey(key);
    }

    //从redis中获取值
    public Object get(String key) {
        /*LinkedHashMap linkedHashMap = (LinkedHashMap) redisTemplate.opsForValue().get(key);
        String json = new JSONObject().toJSONString(linkedHashMap);
        User userEntity = new JSONObject().parseObject(json, User.class);*/
        return redisTemplate.opsForValue().get(key);
    }

    //向redis插入值
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            System.out.println(value);
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
