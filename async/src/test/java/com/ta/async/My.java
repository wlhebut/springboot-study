package com.ta.async;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

public class My {

    @Test
    public void test(){
        Function<String,String> function = (item)->{
            System.out.println(123);
            return null;
        };

        Function<String,String> function2 = String::toUpperCase;

        System.out.println(function.getClass().getName());
        System.out.println(function2.getClass().getName());

        List<String> list = Arrays.asList("lisi", "zhaoliu", "wangw");

        list.forEach(System.out::println);

//        Comparator.reverseOrder();

        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        System.out.println("====================");

        Collections.sort(list,(o1,o2)->{return o1.compareTo(o2);});
        Collections.sort(list, Comparator.naturalOrder());


    }
}
