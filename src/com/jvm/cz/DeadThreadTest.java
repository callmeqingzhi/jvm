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
