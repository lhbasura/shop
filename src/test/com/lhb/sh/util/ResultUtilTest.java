package com.lhb.sh.util;

import com.google.gson.Gson;
import com.lhb.sh.ShopApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultUtilTest extends ShopApplicationTest{

    @Test
    public void getJson() {
        System.out.println("start:");
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 start");
          //  System.out.println("thread1:" + ResultUtil.getJson(1));
            System.out.println("thread1 end");
        }
        );

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start");
          //  System.out.println("thread2:" +  ResultUtil.getJson(2));
            System.out.println("thread2 end");
        });
        thread1.start();
        thread2.start();
    }
}