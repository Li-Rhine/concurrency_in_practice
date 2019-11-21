package threadcoreknowledge.createthreads;

/**
 * @Author: dahai.li
 * @Description: 同时使用Runnable和Thread两种实现线程的方式
 * @Date: Create in 13:30 2019/11/21
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            //传入后被后面的run覆盖
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            //重写了上面run方法
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
