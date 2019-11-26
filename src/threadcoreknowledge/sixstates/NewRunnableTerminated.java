package threadcoreknowledge.sixstates;

/**
 * @Author: dahai.li
 * @Description: 展示线程的 NEW、RUNNABLE、Terminated状态。即使是正在运行，也是Runnable状态
 *  而不是Running
 * @Date: Create in 14:58 2019/11/26
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE的状态，即使是正在运行，也是RUNNABLE,而不是RUNNING
        System.out.println(thread.getState());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Terminated
        System.out.println(thread.getState());

    }




    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
