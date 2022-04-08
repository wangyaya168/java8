package com.king.java8.chapter10;
public class Person {
    private Car car;
    public Car getCar(){return car;};
    public Person(){}

    public void setCar(Car car) {
        this.car = car;
    }
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
    public String getCarInsuranceName1(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }
    public String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
