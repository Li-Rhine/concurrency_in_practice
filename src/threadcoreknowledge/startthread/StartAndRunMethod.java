package threadcoreknowledge.startthread;

/**
 * @Author: dahai.li
 * @Description:  对比start和run两种启动线程的方式
 * @Date: Create in 18:54 2019/11/21
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        runnable.run();

        //run()方法会调用主线程执行run,显然不符合要求

        new Thread(runnable).start();
    }
}
