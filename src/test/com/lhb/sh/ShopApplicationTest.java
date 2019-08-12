package com.lhb.sh;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
@Slf4j
public class ShopApplicationTest  extends AbstractTestNGSpringContextTests {
    @Before
    public void init() {

        System.out.println("Test Begin-----------------");

    }
    @After
    public void after() {

        System.out.println("Test End-----------------");

    }
}
