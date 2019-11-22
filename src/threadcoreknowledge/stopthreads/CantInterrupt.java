package threadcoreknowledge.stopthreads;

/**
 * @Author: dahai.li
 * @Description: 如果while里面放try/catch,会导致中断失效。sleep()在设计时，一旦被中断，就会清除中断信号，所以
 * @Date: Create in 16:38 2019/11/22
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()-> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        //阻塞状态interrupt会报异常
        thread.interrupt();
    }


}
