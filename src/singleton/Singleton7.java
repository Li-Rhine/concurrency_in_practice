package singleton;

/**
 * @Description： 静态内部类(可用)
 *
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton7 {

    private Singleton7() {
    }

    //懒汉式，内部类不会启动加载
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
