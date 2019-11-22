package threadcoreknowledge.stopthreads;

/**
 * @Author: dahai.li
 * @Description: 如果在执行过程中，每次循环都会调用sleep或者wait等方法，那么不需要每次迭代都检查是否以中断 !Thread.currentThread().isInterrupted()的判断条件
 * @Date: Create in 16:31 2019/11/22
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;

            try {
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0 ) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        //阻塞状态interrupt会报异常
        thread.interrupt();
    }
}
