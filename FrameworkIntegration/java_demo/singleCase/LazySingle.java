package com.framework.singleCase;


import java.lang.annotation.Target;

public class LazySingle {
    private LazySingle() {
//        synchronized (LazySingle.class){
//            if(lazySingle!=null){
//                throw new RuntimeException("不要反射破坏");
//            }
//        }
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private volatile static LazySingle lazySingle;
    // 枚举结局反射安全问题
//    static enum getInstance{
//        //创建一个枚举对象，该对象天生为单例
//        INSTANCE;
//        private User user;
//        //私有化枚举的构造函数
//        private SingletonEnum(){
//            user=new User();
//        }
//        public User getInstnce(){
//            return user;
//        }
//    }


    static enum getInstance {
        INSTANCE;
        public static LazySingle getInstance() {
            if (lazySingle == null) {
                synchronized (LazySingle.class) {
                    if (lazySingle == null) {
                        lazySingle = new LazySingle();
                    }
                }
            }
            return lazySingle;
        }
    }

//    public static LazySingle getInstance() {
//        if(lazySingle==null){
//            // 加锁
//            synchronized (LazySingle.class){
//                if (lazySingle == null) {
//                    lazySingle = new LazySingle();
//                    /**
//                     * 不是原子操作
//                     * 1. 分配内存空间
//                     * 2. 执行构造方法，初始化对象化
//                     * 3. 把这个对象执行这个空间
//                     */
//                }
//            }
//        }
//        return lazySingle;
//    }

}
