package deadlock;

/**
 * @Description： 演示哲学家就餐问题导致的死锁
 * @Author： Rhine
 * @Date： 2019/12/19 2:52
 **/
public class DiningPhilosophers {

    public static class Pilosopher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        public Pilosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    doAction("Thinking");
                    synchronized (leftChopstick) {
                        doAction("Picked up left chopstick");
                        synchronized (rightChopstick) {
                            doAction("Pick up chopstick - eating");
                            doAction("Pick down chopstick");
                        }
                        doAction("Picked down left chopstick");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction (String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+ " " + action);
            Thread.sleep((long) (Math.random()*10));
        }
    }

    public static void main(String[] args) {
        Pilosopher[] pilosophers = new Pilosopher[5];
        Object[] chopsticks = new Object[pilosophers.length];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        for (int i = 0; i < pilosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i+1) % chopsticks.length];

            pilosophers[i] = new Pilosopher(leftChopstick, rightChopstick);
            new Thread(pilosophers[i], "哲学家" + (i+1) + "号").start();
        }
    }
}
