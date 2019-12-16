package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description： volatile不适用场景2
 * @Author： Rhine
 * @Date： 2019/12/16 23:05
 **/
public class NoVolatile2 implements Runnable{
    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new NoVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(((NoVolatile2) r).done);
        System.out.println(((NoVolatile2) r).realA.get());

    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            filpDone();
            realA.incrementAndGet();
        }
    }

    private void filpDone() {
        done = !done;
    }
}
