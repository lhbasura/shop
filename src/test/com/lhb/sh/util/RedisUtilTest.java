package com.lhb.sh.util;

import com.lhb.sh.ShopApplicationTest;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class RedisUtilTest  extends ShopApplicationTest {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void set()  {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("lhb", "asura");

    }

    @Test
    public void get(){
        String result=stringRedisTemplate.opsForValue().get("lhb");
        System.out.println("result:"+result);
    }
}
