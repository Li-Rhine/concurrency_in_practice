package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description：两个线程交替打印0-100的奇偶数，用wait和notify
 * @Author： Rhine
 * @Date： 2019/11/27 23:53
 **/
public class WaitNotifyPrintOddEveWait {

    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new TurningRunner(),"偶数").start();

        new Thread(new TurningRunner(),"奇数").start();
    }

    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    static class TurningRunner implements Runnable{
        @Override
        public void run() {
            while (count<100){
                synchronized (lock){
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();//自己线程notify()无效，但是会唤醒另一个线程在sync外面等着，因为另一个线程无锁
                    if (count<100){
                        try {
                            //如果任务还没结束，就让出当前的锁（wait的功能记住是两个：放锁+阻塞）
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
