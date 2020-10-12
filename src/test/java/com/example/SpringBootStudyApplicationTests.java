//测试类的包一定要与SpringBootStudyApplication的包一致,不然会报错
package com.example;

import com.example.model.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class SpringBootStudyApplicationTests {

    @Autowired
    //当出现多个redisTemplate时,可能会冲突,用@Qualifier来指定用的哪个
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //获取Redis连接对象
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        redisConnection.flushDb();
        redisTemplate.opsForGeo();
        redisTemplate.opsForValue().set("namestext1", new User("张三", "男"));
        System.out.println(redisTemplate.opsForValue().get("namestext1"));

    }


    @Test
    public void getJsonStrNew() throws Exception{
        String url="http://172.16.10.123:9091/bllweb/tianyimall/basedata/area?type=1&provincecode=600101";
        //String url="http://172.16.10.123:9091/bllweb/tianyimall/basedata/area?type=1&provincecode={0}&citycode={1}";
        String resp = null;
        // 1、创建httpClient
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = client.execute(httpGet);
        //3、获取实体
        HttpEntity entity = response.getEntity();
        //4、将实体装成字符串
        resp = EntityUtils.toString(entity);
        response.close();
       // return resp.toString();
        System.out.println(resp.toString());
    }


}
