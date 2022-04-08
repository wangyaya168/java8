package com.king.java8.chapter10;

import java.util.Optional;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        Supplier<Person> person2 = Person::new;
        Person person = null;
//        Car car = new Car();
//        Insurance insurance = new Insurance();
//        insurance.setName("宝箱");
//        car.setInsurance(insurance);
//        person.setCar(car);
        Optional<Person> person1 = Optional.ofNullable(person);

        System.out.println(person1.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName).orElse("五"));
    }
}
