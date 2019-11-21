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
    //其实是调用了target.run()方式运行线程
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
