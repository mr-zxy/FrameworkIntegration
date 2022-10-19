package com.relex;

public class Person1 {
    private String name;
    private int age;

    public Person1() {
        System.out.println("Person1无");
//        super();
    }
    public Person1(String name, int age) {
        System.out.println("Person1有");
//        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public void eat() {
        System.out.println("调用无参方法");
    }
    public void eat(int num) {
        System.out.println("调用有参方法");
    }
}
