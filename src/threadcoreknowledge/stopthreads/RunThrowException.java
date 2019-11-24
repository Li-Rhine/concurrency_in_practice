package threadcoreknowledge.stopthreads;

import threadcoreknowledge.createthreads.ThreadStyle;

/**
 * @Description：run无法抛出checked Exception,只能用try/catch
 * @Author： Rhine
 * @Date： 2019/11/24 22:57
 **/
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    throw new Exception();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
