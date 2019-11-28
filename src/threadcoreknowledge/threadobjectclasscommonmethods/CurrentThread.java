package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description： 演示打印main，Thread-0，Thread-1
 * @Author： Rhine
 * @Date： 2019/11/29 2:05
 **/
public class CurrentThread implements Runnable{

    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
