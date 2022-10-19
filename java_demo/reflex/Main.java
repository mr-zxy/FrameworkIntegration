package com.framework.reflex;

public class Main{
    private static final String name="展示干";
    public static void main(String[] args) throws ClassNotFoundException {
        getClassReflex();
    }

    // 反射获取对象
    public static void getClassReflex() throws ClassNotFoundException {
        Class clazz  = Class.forName("reflex.User");
        System.out.println(clazz );
    }
}
