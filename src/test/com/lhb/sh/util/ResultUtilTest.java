package com.lhb.sh.util;

import com.lhb.sh.ShopApplicationTest;
import org.junit.Test;


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