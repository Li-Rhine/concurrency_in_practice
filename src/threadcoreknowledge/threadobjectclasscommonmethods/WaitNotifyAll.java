package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description：3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify,notifyAll.
 *               start先执行不代表线程先启动
 * @Author： Rhine
 * @Date： 2019/11/27 1:56
 **/
public class WaitNotifyAll implements Runnable {
    private static final Object resourceA = new Object();


    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    //如果是notify(),只会唤醒一个线程
//                    resourceA.notify();
                    resourceA.notifyAll();
                    System.out.println("ThreadC notified");
                }
            }
        });

        threadA.start();
        threadB.start();
        //如果去掉sleep(200),线程B会一直waiting下去
        Thread.sleep(200);
        threadC.start();
    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + "got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName() + "waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + "is waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
