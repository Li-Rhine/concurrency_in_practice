package singleton;

/**
 * @Description： 饿汉式（静态常量式）（可用）
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
