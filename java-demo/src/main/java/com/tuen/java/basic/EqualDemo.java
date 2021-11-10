package com.tuen.java.basic;

import com.tuen.java.model.User;

public class EqualDemo {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setAge(1);
        User u2 = new User();
        u2.setAge(1);
        System.out.println(u1==u2);

        User u3 = u2;

        System.out.println(u2 == u3);
    }


}
