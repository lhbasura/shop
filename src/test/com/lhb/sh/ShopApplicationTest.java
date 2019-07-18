package com.lhb.sh;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)

public class ShopApplicationTest {
    @Before
    public void init() {

        System.out.println("Test Begin-----------------");

    }
    @After
    public void after() {

        System.out.println("Test End-----------------");

    }
}
