package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: dahai.li
 * @Description: 展示线程sleep的时候不释放synchronizd的monitor,
 *               等sleep时间到了以后，正常结束后才释放锁
 * @Date: Create in 14:42 2019/11/28
 */
public class SleepDontReleaseMonitor implements Runnable{

    public static void main(String[] args) {
        SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();
        new Thread(sleepDontReleaseMonitor).start();
        new Thread(sleepDontReleaseMonitor).start();
    }
    
    
    
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了monitor.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"退出了同步代码块");
    }
}
