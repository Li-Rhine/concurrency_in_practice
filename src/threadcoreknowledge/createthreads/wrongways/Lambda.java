package threadcoreknowledge.createthreads.wrongways;

/**
 * @Author: dahai.li
 * @Description:  Lambda表达式创建线程
 * @Date: Create in 16:07 2019/11/21
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

    }
}
