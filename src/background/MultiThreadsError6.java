package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description： 构造函数中新建线程
 * @Author： Rhine
 * @Date： 2019/12/9 22:28
 **/
public class MultiThreadsError6 {

    private Map<String, String> states;

    public MultiThreadsError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1", "周一");
                states.put("2", "周二");
                states.put("3", "周三");
                states.put("4", "周五");
            }
        }).start();

    }

    public Map<String, String> getStates(){
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();
        Map<String, String> states = multiThreadsError6.getStates();
        System.out.println(states.get("1"));
        states.remove("1");
        System.out.println(states.get("1"));

    }
}
