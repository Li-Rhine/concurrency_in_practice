package singleton;

/**
 * @Description： 懒汉式（线程不安全）（不可用）
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
