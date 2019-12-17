package singleton;

/**
 * @Description： 双重检查锁（推荐面试使用）(可用)
 *                 线程安全；延迟加载；效率较高
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public class Singleton6 {
    //需要加上volatile
    //因为原子操作：基础变量的赋值、引用的赋值、原子类里操作是原子的。对于新建对象可不是原子操作的，使用volatile禁止重排序
    private volatile static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
