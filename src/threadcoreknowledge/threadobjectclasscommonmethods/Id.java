package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Description： ID从1开始，JVM运行起来之后，我们自己创建的线程ID早已不是2
 * @Author： Rhine
 * @Date： 2019/12/2 23:34
 **/
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID"+ Thread.currentThread().getId());
        System.out.println("子线程的ID"+ thread.getId());

    }
}
