package threadcoreknowledge.createthreads;

/**
 * @Description：  用Runnable方式创建线程
 * @Author： Rhine
 * @Date： 2019/11/21 2:33
 **/
public class RunnableStyle implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }


    @Override
    public void run() {
        System.out.println("用Runable方法实现线程");
    }
}
