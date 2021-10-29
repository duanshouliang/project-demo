package com.tuen.java.optional;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tuen.java.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Optional容器的使用
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Integer i= 100;
        // 将对象放入容器, 放到容器中的对象不能为空（null）
        Optional<Integer> optional = Optional.of(i);
//        Optional<Integer> optional = Optional.empty();
        //判断容器中是否有内容
        boolean present = optional.isPresent();
        if(present) {
            // 获取容器中的对象，没有内容时会抛出"No value present"异常
            Integer content = optional.get();
            System.out.println(content);
        }
        //如果容器中有值，则返回true
        if(optional.isPresent()){
            System.out.println("有值");
        }else {
            System.out.println("无值");
        }
        // 使用map（value -> function）, 返回function的结果，但是使用map的时候必须带上orElse， 确保有结果
        int result = optional.map(item -> add(item)).orElse(0);

        optional = Optional.empty();
        int result2 = optional.map(item -> add(item)).orElseGet(()->90);
        System.out.println(result);
        System.out.println(result2);

        /**
         * orElse和orElseGet的区别
         * 无论Optional容器中是否有值，都会执行orElse
         * 只有Optional容器中没有值时才会执行orElseGet
         */
        Optional<String> test = Optional.empty();
        System.out.println(test.map(ele -> true).orElse(print("do: orElse")));
        System.out.println(test.map(ele -> true).orElseGet(() ->print("do: orElseGet")));

        test = Optional.of("shuliang");
        System.out.println(test.map(ele -> true).orElse(print("do: orElse")));
        System.out.println(test.map(ele -> true).orElseGet(() ->print("do: orElseGet")));


        String result3 = test.filter(item -> item.equals("shuliang2")).orElse("duan");
        System.out.println(result3);

        List<User> userList = Lists.newArrayList();
        User u1 = new User();
        u1.setAge(100);
        u1.setName("shu");
        userList.add(u1);
//        userList.add(u2);
        User u3 = new User();
        u3.setAge(102);
        u3.setName("liang");
        userList.add(u3);

        Optional<User> optionalUser = Optional.of(u1);

        User userResult = optionalUser.filter(user -> StringUtils.isBlank(user.getName())).orElse(null);
        System.out.println(JSON.toJSONString(userResult));

        optionalUser.ifPresent(u -> u.setAge(1100));
        System.out.println(optionalUser.get().getAge());



        //Optional.ofNullable 将对象放到容器中，且对象不能为空
        User u2 = new User();
        u2.setAge(101);
        u2.setName("liang");
        Optional.ofNullable(u2).ifPresent(u -> u.setAge(89));
        System.out.println(u2.getAge());
    }


    public static int add (int i){
        return i * i;
    }


    public static boolean print(String content){
        System.out.println(content);
        return false;
    }
}
