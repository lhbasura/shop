package com.lhb.sh;

import org.junit.Test;

public class UnTrackTest {
    class Parent{
         String name="parent";
        void print()
        {
            System.out.println(this.name);
        }
    }
    class Kid extends  Parent{
         String name="kid";
    }
    @Test
    public void  test(){
        Kid kid=new Kid();
        kid.print();
    }

}
