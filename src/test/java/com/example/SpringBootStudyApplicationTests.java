//测试类的包一定要与SpringBootStudyApplication的包一致,不然会报错
package com.example;

import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;


@SpringBootTest
class SpringBootStudyApplicationTests {

    //  @Autowired
    // DataSource dataSource;

    @Autowired
    /*当出现多个redisTemplate时,可能会冲突,用@Qualifier来指定用的哪个*/
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        User u =new User("ade长啥","1517看看");
        //获取Redis连接对象
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.flushDb();
        redisTemplate.opsForGeo();
        redisTemplate.opsForValue().set("namestext1", u);
        System.out.println(redisTemplate.opsForValue().get("namestext1"));

    }


}
