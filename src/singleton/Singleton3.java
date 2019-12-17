package singleton;

/**
 * @Description： 懒汉式（线程不安全）（不可用）
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
