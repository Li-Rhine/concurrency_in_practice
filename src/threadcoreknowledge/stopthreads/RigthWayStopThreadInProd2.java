package threadcoreknowledge.stopthreads;

/**
 * @Author: dahai.li
 * @Description: 最佳实践2: 在catch语句中调用 Thread.currentThread().interrupted() 来恢复设置中断状态，以便与在
 * 后续的执行中，依然能够检查到刚才发生了中断，回到刚才 RigthWayStopThreadInProd 补上中断，让它跳出
 * @Date: Create in 16:59 2019/11/24
 */
public class RigthWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted,程序运行结束");
                break;
            }
                reInterrupt();
            }
        }


    private void reInterrupt(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //sleep会清楚中断标志
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RigthWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
