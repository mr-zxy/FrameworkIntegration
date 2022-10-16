package com.framework.singleCase;

public class Holder {
    // 静态内部类
    private Holder(){
        System.out.println(Thread.currentThread().getName());
    }

    public static Holder getInstance() {
        if (InnerClass.holder == null) {
            return InnerClass.holder;
        }
        return InnerClass.holder;
    }
    public static class InnerClass{
        private static final Holder holder=new Holder();
    }
}
