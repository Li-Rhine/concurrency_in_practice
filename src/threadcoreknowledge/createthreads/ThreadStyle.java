package threadcoreknowledge.createthreads;

/**
 * @Description：用Thread方式实现线程
 * @Author： Rhine
 * @Date： 2019/11/21 2:41
 **/
public class ThreadStyle extends Thread {

    @Override
    //重写run方法
    public void run() {
        System.out.println("用Thread类实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
