package com.example.springbootapps;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void applicationContextTest() {
        DataApplication.main(new String[] {});
    }

}
