package com.relex;

public class User {
    public String name="张三";
    private String name1="张三1";
    private String age="张三1";

    public User(String name, String name1) {
        System.out.println("2构造");
        this.name = name;
        this.name1 = name1;
    }

    public User() {
        System.out.println("无构造");
    }

    public User(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public User(String name, String name1, String age) {
        this.name = name;
        this.name1 = name1;
        this.age = age;
    }
    public void run(){
        System.out.println("run");
    }
}
