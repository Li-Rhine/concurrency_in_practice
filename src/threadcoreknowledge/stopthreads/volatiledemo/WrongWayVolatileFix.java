package threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description：用中断来修复刚才无尽等待问题
 * @Author： Rhine
 * @Date： 2019/11/25 23:06
 **/
public class WrongWayVolatileFix {
    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatileFix body = new WrongWayVolatileFix();

        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = body.new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");

        producerThread.interrupt();
        System.out.println(producer.canceled);
    }


    class Producer implements Runnable {

        public volatile boolean canceled = false;


        BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }


        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        //队列满了会阻塞在这一步
                        storage.put(num);
                        System.out.println(num + "是100的倍数,被放到仓库中了");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者结束运行");
            }
        }
    }

    class Consumer {
        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            if (Math.random() > 0.95) {
                return false;
            }
            return true;
        }
    }


}
