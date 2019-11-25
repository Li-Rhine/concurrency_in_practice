package threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * @Author: dahai.li
 * @Description: 演示用volatile的局限part2 陷入阻塞时，volatile无法停止线程的
 * 此例中，生产者的生产会很快，消费者消费很慢，所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 * @Date: Create in 11:46 2019/11/25
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storeage = new ArrayBlockingQueue(10);

        Producer producer = new Producer((BlockingDeque) storeage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer((BlockingDeque) storeage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storeage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");

        //一旦消费者不需要更多数据了，我们应该让生产者也停下来，但是实际情况
        producer.canceled = true;
    }
}

class Producer implements Runnable {

    public volatile boolean canceled = false;


    BlockingDeque storage;

    public Producer(BlockingDeque storage) {
        this.storage = storage;
    }


    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数,被放到仓库中了");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}

class Consumer {
    BlockingDeque storeage;

    public Consumer(BlockingDeque storeage) {
        this.storeage = storeage;
    }

    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}
