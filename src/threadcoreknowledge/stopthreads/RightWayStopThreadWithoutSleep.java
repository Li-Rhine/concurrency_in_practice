package threadcoreknowledge.stopthreads;

/**
 * @Description：run方法内没有sleep或wait方法时，停止线程
 * 使用interrupt()根本停不下来，但是在执行业务程序里面需要对isInterrupted()进行判断
 * @Author： Rhine
 * @Date： 2019/11/22 1:07
 **/
public class RightWayStopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE /2) {
            if (num % 2 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }
}
