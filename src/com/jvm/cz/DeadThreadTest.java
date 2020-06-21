package com.jvm.cz;


public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("current thread: " + Thread.currentThread().getName() + "开始");
            new DeadThread();
            System.out.println("current thread: " + Thread.currentThread().getName() + "结束");
        };
        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        thread1.start();
        thread2.start();

    }

    //虚拟机必须保证一个类的<clinit>()方法在多线程中只会被加载一次，如下代码，只会有一个线程进入DeadThread静态代码块中(clinit)方法
    static class DeadThread {
        static {
            if (true) {
                System.out.println("current thread: " + Thread.currentThread().getName());
                while (true) {
                }
            }
        }
    }
}
