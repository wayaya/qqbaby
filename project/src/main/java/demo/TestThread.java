package demo;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-21
 * Time: ионГ12:40
 */
public class TestThread {
    public static void main(String[] args) {

        System.out.println("start:" + System.currentTimeMillis());
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        t1.start();
        t2.start();


        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("endt:" + System.currentTimeMillis());


    }
}
