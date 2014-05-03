package hello;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-5-1
 * Time: ����12:01
 */
public class ProjectTest {

    @Test
    public void test() {
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable<String> call = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(500);
                return "Feture";
            }
        };
        Future<String> task = exec.submit(call);
        String result = null;
        try {
            while (!task.isDone()) {
                result = task.get(200, TimeUnit.MILLISECONDS);//��ʱʱ��Ϊ200����
                System.out.println(result);
            }
        } catch (InterruptedException e) {
            result = "InterruptedException";
        } catch (ExecutionException e) {
            result = "ExecutionException";
        } catch (TimeoutException e) {
            result = "TimeoutException";
        }

        //�ر��̳߳�
        exec.shutdown();
    }
}
