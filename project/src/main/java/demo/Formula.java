package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-22
 * Time: ����8:56
 */
public class Formula {


    /**
     * ���������еڶ�������
     * ֻ����һ�Σ����ҳ��ڶ�������
     * @param data ����
     * @return Interger secondMax,null��ʾδ�ҵ�
     */
    public Integer GetSecondMaxNumber(int data[]) {
        int i, max;

        max = data[0];
        Integer secondMax = Integer.MIN_VALUE;
        for (i = 1; i < data.length; i++) {
            if (data[i] > max) { //�����data[i]�������ֵ����ԭ���ֵ��Ϊ�ڶ���data[i]����Ϊ���ֵ
                secondMax = max;
                max = data[i];
            } else if (data[i] > secondMax && data[i] < max) { //���data[i]���ڵ�һ����ڶ���֮�䣬��data[i]����Ϊ�ڶ���
                secondMax = data[i];
            }
        }

        //��������������������ƶ���ͬ����˵��û�еڶ���
        if (secondMax == Integer.MIN_VALUE) {
            secondMax = null;//null��ʾʧ��,û�еڶ���ֵ
        }

        return secondMax;//����1��ʾ�ɹ�
    }




}
