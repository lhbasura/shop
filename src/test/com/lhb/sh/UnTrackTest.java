package com.lhb.sh;

import org.junit.Test;

import java.util.Date;

public class UnTrackTest {
    class Parent {
        String name = "parent";

        void print() {
            System.out.println(this.name);
        }
    }

    class Kid extends Parent {
        String name = "kid";
    }

    @Test
    public void test() {
        Date date = new Date();
        System.out.println(date.getTime());
    }


}
