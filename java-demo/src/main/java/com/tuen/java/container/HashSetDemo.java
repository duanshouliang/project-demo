package com.tuen.java.container;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. HashSet是基于HashMap实现的
 * 2. 非线性安全的
 * 3. add时将要新增的对象作为key，将Object对象作为值
 * 4. 默认大小即为HashMap的默认的小16
 * 5. 加载因子为0.75
 * 6. 操作HashSet的本质其实就是对HashMap的操作
 * 7. 只能有一个为空的元素
 * 8. HashSet是无序的
 * 9. HashSet所有的元素都不同
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        for(String str:set) {
            System.out.println(str);
        }
    }
}
