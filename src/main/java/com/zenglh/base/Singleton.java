package com.zenglh.base;

/**
 * @author zenglh
 * @date 2020/11/4 10:58
 */
public class Singleton {

    private Singleton() {

    }

    static Singleton instance;

    //会有报空指针异常的问题
    //1.A线程执行到new Singleton()这一句时，指令会分为
    //(1)开辟内存空间
    //(2)创建Singleton对象
    //(3)把内在地址赋值给instance
    //如果是按顺序执行，没有问题，但是编译器会重排CPU指令
    //会造成(1)(3)(2)这种顺序，那线程B执行到第一个判断时
    //A线程刚好执行到(3)，这时就会返回一个只分配了内存地址，
    //但是没有实体化对象的instance
    static Singleton getInstance() {
        if (null == instance) {
            synchronized(Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
