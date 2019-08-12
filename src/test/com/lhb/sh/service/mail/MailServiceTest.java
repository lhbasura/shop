package com.lhb.sh.service.mail;

import com.lhb.sh.ShopApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;


@Slf4j
public class MailServiceTest extends ShopApplicationTest {

    @Resource
    MailService service;


    @Test
    public void sendVerifyMail() throws MessagingException {
        final CountDownLatch latch = new CountDownLatch(2);//有多少个线程这个参数就是几
        Thread thread1=new Thread(()->{
            for(int i=0;i<10;i++)
            {
                System.out.println("thread1:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();//每执行完一个就递减一个
        });
        Thread thread2=new Thread(()->{
            for (int i=0;i<10;i++)
            {
                System.out.println("thread2:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();//每执行完一个就递减一个

        });

        thread1.start();
        thread2.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
     //   Assert.assertEquals(user.getUsername(),"lhb");
    }
    public void reverseList(LinkedList node)
    {
    }
    @Test
    public void test()
    {
    }

}