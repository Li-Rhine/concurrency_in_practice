package threadcoreknowledge.createthreads.wrongways;

/**
 * @Author: dahai.li
 * @Description: 使用匿名内部类的方式创建线程
 * @Date: Create in 16:04 2019/11/21
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
