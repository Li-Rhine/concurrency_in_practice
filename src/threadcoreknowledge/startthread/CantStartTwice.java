package threadcoreknowledge.startthread;

/**
 * @Author: dahai.li
 * @Description:  演示不能两次调用start方法，否则会报错
 * @Date: Create in 19:07 2019/11/21
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();

    }
}
