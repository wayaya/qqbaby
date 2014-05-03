package demo;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-5-1
 * Time: 上午6:37
 */
public class Run implements Runnable {

    public static boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod() {
        while (isContinuePrint == true) {
            /*System.out.println("run printStringMethod threadName="
                    + Thread.currentThread().getName());*/
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }

    public static void main(String[] args) {
        try {
            //差不多的代码，为什么我不死循环！
            Run printStringService = new Run();
            new Thread(printStringService).start();
            Thread.sleep(1000);
            System.out.println("我要停止它！stopThread="
                    + Thread.currentThread().getName());
            Run.isContinuePrint = false;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

