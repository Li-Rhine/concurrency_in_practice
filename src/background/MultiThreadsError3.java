package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description： 发布逸出
 * @Author： Rhine
 * @Date： 2019/12/9 22:28
 **/
public class MultiThreadsError3 {

    private Map<String, String> states;

    public MultiThreadsError3() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周五");
    }

    public Map<String, String> getStates(){
        return states;
    }



    /*****************  解决：返回一个副本  ************************************/
    public Map<String, String> getStatesImproved(){
        return new HashMap<>(states);
    }
    /**************************************************************************/

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        Map<String, String> states = multiThreadsError3.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
        multiThreadsError3.getStatesImproved().remove("1");
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
    }
}
