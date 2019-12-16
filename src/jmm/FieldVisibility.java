package jmm;

/**
 * @Author: dahai.li
 * @Description:  演示可见性带来的问题
 * @Date: Create in 17:22 2019/12/12
 */
public class FieldVisibility {
    volatile int a = 1;
    volatile int b = 2;

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b=" + b +";a="+ a);
    }

    public static void main(String[] args) {

        while (true) {

            FieldVisibility test = new FieldVisibility();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }

    }


}
