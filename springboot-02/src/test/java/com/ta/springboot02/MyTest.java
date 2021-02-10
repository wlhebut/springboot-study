package com.ta.springboot02;

import com.google.common.base.Optional;
import com.ta.springboot02.pojo.Car;
import com.ta.springboot02.pojo.Insurance;
import com.ta.springboot02.pojo.User1;


public class MyTest {

    public static <T> T defaultIfAbsent(T newValue, T defaultValue) {
        return Optional.fromNullable(newValue)
                .or(Optional.fromNullable(defaultValue))
                .orNull();
    }

    public static void main(String[] args) {

        User1 user = new User1();

        Insurance insurance = new Insurance();
        insurance.setInsuraceName("cgs");

        Car car = new Car();
        car.setCarName("bl");
        car.setInsurance(insurance);
        user.setUserName("wl");
        user.setCar(null);


        String s = defaultIfAbsent(null, null);
        System.out.println(s);

    }
}
