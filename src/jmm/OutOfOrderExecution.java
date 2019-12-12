package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @Description： 演示重排序的现象
 * “直到达到某个条件才停止”，测试小概率事件
 * @Author： Rhine
 * @Date： 2019/12/12 1:14
 **/
public class OutOfOrderExecution {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });


            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            two.start();
            one.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第"+ i +"次 （"+ x +"," +y +")";
            if (x == 0 && y == 0){
                System.out.println(result);
                break;
            }else {
                System.out.println(result);
            }

        }
    }
}
