package threadcoreknowledge.stopthreads;

/**
 * @Description：注意Thread.interrupt()方法的目标对象是“当前线程”，而不管本方法来自于那个对象
 * @Author： Rhine
 * @Date： 2019/11/26 2:11
 **/
public class RightWayInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( ; ; ){

                }
            }
        });

        //启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());//true
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());//静态方法，指调用的main线程，false,
        //获取中断标志
        System.out.println("isInterrupted:" + Thread.interrupted());// false

        System.out.println("isInterrupted:" + threadOne.isInterrupted());//true
        threadOne.join();
        System.out.println("Main thread is over");

    }



}
