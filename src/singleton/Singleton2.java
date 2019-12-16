package singleton;

/**
 * @Description： 饿汉式（静态代码块）（可用）
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton2 {
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
