package com.framework.singleCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
////                LazySingle.getInstance();
////                Holder.getInstance();
//            }).start();
//        }
//    }
public static void main(String[] args) throws Exception{
    // 反射
//    LazySingle instance=LazySingle.getInstance();
        LazySingle instance=LazySingle.getInstance.INSTANCE.getInstance();
    Constructor<LazySingle> declaredConstructor = null;
    declaredConstructor = LazySingle.class.getDeclaredConstructor();
//    declaredConstructor.setAccessible(true);
//    LazySingle instance2=declaredConstructor.newInstance();
//    System.out.println(instance);
//    System.out.println(instance2);
}
}
