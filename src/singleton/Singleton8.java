package singleton;

/**
 * @Description： 枚举单例 (可用)
 *                优点：1、写法简单 2、线程安全有保障 3、避免反序列化破坏单例
 *
 * @Author： Rhine
 * @Date： 2019/12/17 2:16
 **/
public enum  Singleton8 {
    INSTANCE;

    public void whatever() {

    }
}
