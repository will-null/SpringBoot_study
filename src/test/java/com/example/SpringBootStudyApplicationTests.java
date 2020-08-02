//测试类的包一定要与SpringBootStudyApplication的包一致,不然会报错
package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


@SpringBootTest
class SpringBootStudyApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

        System.out.println(dataSource.getClass());
    }


}
