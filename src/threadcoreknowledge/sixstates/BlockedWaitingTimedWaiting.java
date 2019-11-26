package threadcoreknowledge.sixstates;

/**
 * @Author: dahai.li
 * @Description: 展示Blocked, Waiting, TimedWaiting
 * @Date: Create in 15:37 2019/11/26
 */
public class BlockedWaitingTimedWaiting implements Runnable {

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000)
        System.out.println(thread1.getState());
        //打印出BLOCKED状态，因为thread2想拿到sync()的锁却拿不到
        System.out.println(thread2.getState());

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出waiting状态
        System.out.println(thread1.getState());


    }

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
