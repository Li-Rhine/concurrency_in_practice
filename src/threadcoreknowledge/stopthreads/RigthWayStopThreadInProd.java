package threadcoreknowledge.stopthreads;

/**
 * @Author: dahai.li
 * @Description: 最佳实践：catch了InterruptException之后的优先选择：在方法签名中抛出异常
 * 那么在run()就会强制和try/catch
 * @Date: Create in 16:59 2019/11/22
 */
public class RigthWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws  InterruptedException{
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RigthWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
