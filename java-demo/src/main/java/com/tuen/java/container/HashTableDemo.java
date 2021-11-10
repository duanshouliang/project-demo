package com.tuen.java.container;

import java.util.Hashtable;

/**
 * 1. 底层数据结构为数组加链表，即Entry<?, ?>[] table， 其中Entry是一个链表
 * 2. 除了构造方法外，其他方法都用synchronized修饰，因此是线程安全的
 * 3. 默认大小为11，加载因子为0.75
 *
 * Get方法的过程：
 * 1. 通过hash = key.hashCode()获取key的哈希值
 * 2. 使用index  = （hash & 0x7FFFFFFF） % table.length，定位到链表
 * 3. 获取到链表后遍历链表并根据哈希值和key值是否相等来返回目标key的value
 * 4. 扩容时扩大至原来的两倍 + 1
 *
 *
 * Put方法的过程：
 * 1. 通过hash = key.hashCode()获取key的哈希值
 * 2. 使用index  = （hash & 0x7FFFFFFF） % table.length，定位到链表，其中&表示按位与运算都为1时结果为1，否则为0
 * 3. 如果key已经存在，则执行以下逻辑
 *     * 遍历index索引的链表，并将链表中key的老value替换为新value
 * 4. 如果key不存在，则以下逻辑
 *     * 判断是否需要扩容和rehash
 *     * 根据index找到目标链表，用目标key和value构造Entry对象并插入到链表的尾部
 *
 *
 * Entry类的hashCode（）方法过程:
 *
 * h = hash ^ Objects.hashCode(value)， hash为key的哈希值
 *     ^：是java中的按位异或运算符，从高位开始比较，相同则为1，不同则为0；
 *
 * HashTable的hashCode（）方法过程：
 * 遍历整个HashTable，并把所有的Entry的哈希值之和作为HashTable的哈值值
 *
 *
 * 扩容时为什么要rehash？
 * hashtable在put新元素时需要根据链表数组长度来计算新元素所在的链表的index，所以扩容之后原有元素所在的链表的index通过扩容后的链表数组长度来计算可能定位不到，因此需要做rehash将旧链表数组映射到新链表数组上，即重新分配地址。
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(1);

        hashtable.put("key","value");
        hashtable.put("key","value");
    }
}
