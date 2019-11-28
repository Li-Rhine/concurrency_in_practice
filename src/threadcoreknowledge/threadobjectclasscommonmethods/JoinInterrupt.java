package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description： 演示join期间被中断的效果
 *                join中断的是主线程，主线程这时是waiting状态
 *                已被interrupt()会抛出异常，并不代表程序不往下走
 * @Author： Rhine
 * @Date： 2019/11/29 0:00
 **/
public class JoinInterrupt {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished.");
                } catch (InterruptedException e) {
                    System.out.println("子线程中断");
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            thread1.interrupt();
        }
        System.out.println(Thread.currentThread().getName()+"子线程已运行完毕");
    }
}
