package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-22
 * Time: 上午8:56
 */
public class Formula {


    /**
     * 返回数组中第二大数据
     * 只遍历一次，就找出第二大数据
     * @param data 数组
     * @return Interger secondMax,null表示未找到
     */
    public Integer GetSecondMaxNumber(int data[]) {
        int i, max;

        max = data[0];
        Integer secondMax = Integer.MIN_VALUE;
        for (i = 1; i < data.length; i++) {
            if (data[i] > max) { //如果有data[i]大于最大值，则原最大值降为第二大，data[i]升级为最大值
                secondMax = max;
                max = data[i];
            } else if (data[i] > secondMax && data[i] < max) { //如果data[i]介于第一大与第二大之间，则data[i]升级为第二大
                secondMax = data[i];
            }
        }

        //处理特殊情况，即所有制都相同，则说明没有第二大
        if (secondMax == Integer.MIN_VALUE) {
            secondMax = null;//null表示失败,没有第二大值
        }

        return secondMax;//返回1表示成功
    }




}
