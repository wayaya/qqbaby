package demo;

import java.io.File;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-5-1
 * Time: 上午6:37
 */
public class Test {// volatile
    //    private static volatile boolean stop = false;
    private static boolean stop = false;


    public static void main(String[] args) throws Exception {

        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
//                    System.out.println("hello");
//                    System.out.print("hello");
                }
            }
        });
        t.start();

        Thread.sleep(1000);
        System.out.println("Stop Thread");
        stop = true;
    }

    /**
     * 定义一个学生类
     */
    public class Student {
        String name;
        boolean sex;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


}
