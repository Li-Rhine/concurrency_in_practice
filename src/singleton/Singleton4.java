package singleton;

/**
 * @Description： 懒汉式（线程安全）（不推荐用）
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
