package com.zenglh.base;

/**
 * @author zenglh
 * @date 2020/11/3 18:57
 */
public class Test1 {

    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public long calc() throws InterruptedException {
        Thread t1 = new Thread(() -> {
           add10K();
        });
        Thread t2 = new Thread(() -> {
           add10K();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Test1 test1 = new Test1();
        System.out.println(test1.calc());
    }

}
