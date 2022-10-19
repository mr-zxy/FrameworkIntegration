package com.relex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取包名、类名
        Class aClass = Class.forName("com.relex.User");
        Package aPackage = aClass.getPackage(); // 获取包名 package com.relex
        String simpleName = aClass.getSimpleName(); // 获取类名称 User
        String name = aClass.getName(); // 完整类名 com.relex.User
        //获取成员变量定义信息 public java.lang.String com.relex.User.name //public java.lang.String com.relex.User.name1
        for (Field field : aClass.getFields()) {
//            System.out.println(field);
        }

//     获取本类定义的成员变量,包括私有,但不包括继承的变量   private java.lang.String com.relex.User.name  public java.lang.String com.relex.User.name1

        Field[] declaredField = aClass.getDeclaredFields();
        for (Field field : declaredField) {
//            System.out.println(field);
        }
        Field name1 = aClass.getField("name");   // 获取变量
        Field name11 = aClass.getDeclaredField("name1");  // 获取变量无作用域



        //获取构造方法定义信息
        Constructor constructor = aClass.getConstructor(String.class,String.class,String.class);
//        for (Constructor constructor : aClass.getConstructors()) {
//            System.out.println(constructor+"constructor");
//        }

        // 方法
//        for (Method method : aClass.getMethods()) {
//                    System.out.println(method);
//        }
//        Method getMethod = aClass.getMethod("run");
//        System.out.println(getMethod);

        // 反射创建实例

        Constructor o=aClass.getConstructor(String.class,String.class);
          o.newInstance("王五", "张三");
//        Constructor constructor1 = aClass.getConstructor(String.class, String.class);


        // 反射调用成员变量
//        Field name2 = aClass.getField("name");
//        name2.setAccessible(true);
//        String name2n=name2.getName();
//
//        System.out.println(name2n);

        // 调用成员方法

        Class clazz = Class.forName("com.relex.Person1");
//        Constructor c = clazz.getConstructor(String.class, int.class);    //获取有参构造
//        Person1 p = (Person1) c.newInstance("张三", 23);                        //通过有参构造创建对象
        Constructor c = clazz.getConstructor();
        Person1 p = (Person1) c.newInstance();
        Method m = clazz.getMethod("eat");                                //获取eat方法
        m.invoke(p);

        Method m2 = clazz.getMethod("eat", int.class);                    //获取有参的eat方法
        m2.invoke(p, 10);

    }
}
