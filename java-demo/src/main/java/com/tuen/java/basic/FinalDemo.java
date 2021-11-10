package com.tuen.java.basic;

public class FinalDemo {
    final static int i = 0;
    //或者通过静态代码快复制
    final static int i2;
    static {
        i2=3;
    }

    final int b=0;
    //或者通过代码块中复制
    final int b2;
    {
        b2 = 1;
    }


}
