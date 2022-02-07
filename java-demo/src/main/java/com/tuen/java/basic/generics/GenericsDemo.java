package com.tuen.java.basic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 */
public class GenericsDemo {

    public static void main(String[] args) {
        // 上界用extends关键字声明，表示参数化的类型可能是所指定的类或者其任意的子类，例如<? extends B>, 泛型的上界就是类B。
        // 程序List<? extends B> 指定了B为上界，但是不能确定具体是B的哪一种类，可能是B，也可能是B的任意子类。
        // 由于类型不确定，所以指定了上界的时，向list中增加元素则在编译时就会报错
        List<? extends B> list1 = new ArrayList<>();  // 上界

        /**
         * 下界使用super关键值声明，表示参数化的类型可能是指定的类型或者指定类型的任意父类
         */
        List<? super B> list2 = new ArrayList<>();   // 下界

        A a = new A();
        B b = new B();
        Sub_B sub_b = new Sub_B();
        C c = new C();
        Object o = new Object();
        /**
         * 不能添加任何元素，因为list中具体是B的那种自类型无法确定
         */
//        list1.add(o);
//        list1.add(a);
//        list1.add(b);
//        list1.add(c);
//        list1.add(sub_b);

        o = list1.get(0);
        a = list1.get(0);
        b = list1.get(0);
        // 编译错误，编译器无法向下转型
//        c = list1.get(0);
//        sub_b = list1.get(0);
        //编译保存，因为list中具体是B的那种父类无法确定
//        list2.add(o);
//        list2.add(a);
        list2.add(b);
        list2.add(c);
    }
}
