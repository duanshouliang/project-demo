package com.tuen.java.container;

import java.util.*;

/**
 * 实现了Serializable，因此支持系列化传输
 * 实现了RandomAccess接口，因此支持随机访问
 * 实现了Cloneable，因此支持对象克隆
 *
 * 底层使用数组存储，默认大小为10
 *
 * 每次扩容时增加原来的一半，使用位计算实现：int newCapacity = oldCapacity + （oldCapacity >> 1）;
 *
 * 使用new Arraylist() 创建一个空list时，在第一次add元素时会将list 的大小设置为默认大小即10
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> set = new ArrayList<>();
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
        set.add("ddd");
        set.forEach(item ->{
            System.out.println(item);
        });

        for(String item : set){
            System.out.println(item);
        }

        for(int i=0;i<set.size() ;i++){
            System.out.println(set.get(i));
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        Collections.synchronizedList()
    }
}
