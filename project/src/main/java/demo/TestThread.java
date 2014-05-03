package demo;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-21
 * Time: 上午12:40
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
                for (int i = 0; i < 30; i++) {
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        //创建两个线程，并启动
        t1.start();
        t2.start();

        //同时主线程也开始跑逻辑，但是主线程跑的时间段，两个子线程需要在主线程进行合并
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        //两个子线程需要在，主线程中进行合并
        try {
            t1.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("endt:" + System.currentTimeMillis());


    }
}
