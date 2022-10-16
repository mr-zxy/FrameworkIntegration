package com.framework.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.framework.annotation.Person");
        System.out.println("==============类注解解析==============");
        printClassAnno(clazz);

        System.out.println("==============成员变量注解解析==============");
        printFieldAnno(clazz);
//
        System.out.println("==============成员方法注解解析==============");
        printMethodAnno(clazz);
//
        System.out.println("==============构造器注解解析==============");
        printConstructorAnno(clazz);

    }

    /**
     * 打印类的注解
     */
    private static void printClassAnno(Class<?> clazz) throws ClassNotFoundException {
        //判断是否有AuthorAnnotatin注解
        if(clazz.isAnnotationPresent(ClassAnnotation.class)) {
            //获取AuthorAnnotatin类型的注解
            ClassAnnotation annotation = clazz.getAnnotation(ClassAnnotation.class);
            System.out.println(annotation.name()+"\t"+annotation.version());
        }
    }


    /**
     * 打印成员变量的注解
     */
    private static void printFieldAnno(Class<?> clazz) throws ClassNotFoundException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(FieldAnnotation.class)) {
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                System.out.println(annotation.name()+"\t"+annotation.value());
            }
        }
    }
//
//    /**
//     * 打印成员变量的注解
//     */
    private static void printMethodAnno(Class<?> clazz) throws ClassNotFoundException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(MethodAnnotation.class)) {
                MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
                System.out.println(annotation.name()+"\t"+annotation.type());
            }
        }
    }
    /**
     * 打印成员变量的注解
     */
    private static void printConstructorAnno(Class<?> clazz) throws ClassNotFoundException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if(constructor.isAnnotationPresent(ConstructorAnnotatin.class)) {
                ConstructorAnnotatin annotation = constructor.getAnnotation(ConstructorAnnotatin.class);
                System.out.println(annotation.constructorName()+"\t"+annotation.remark());
            }
        }
        System.out.println("无");
    }

}