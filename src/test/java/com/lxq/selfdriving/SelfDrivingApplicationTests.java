package com.lxq.selfdriving;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelfDrivingApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testNumbers() {
        Integer number = 1001;
        String numStr = number.toString();
        char firstDigit = numStr.charAt(0);
        System.out.println(firstDigit);
    }
}
