package demo;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-30
 * Time: ÏÂÎç11:06
 */
public class Threads {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        SubThread thread = new SubThread();

        Future future = executorService.submit(thread, 1000);

        mainThreadOtherWork();

        System.out.println("now waiting sub thread done.");
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("now all done.");

        executorService.shutdown();

    }

    private static void mainThreadOtherWork() {
        System.out.println("main thread work start");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread work done.");
    }

    public static class SubThread extends Thread {
        @Override
        public void run() {
            System.out.println("sub thread start working.");
            try {
                sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub thread stop working.");
        }

    }


}
