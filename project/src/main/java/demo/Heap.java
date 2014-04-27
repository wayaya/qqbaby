package demo;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-23
 * Time: ����6:51
 */
public class Heap {

    /**
     * �������ݷ��ص�m�����
     *
     * @param data ԭʼ����
     * @param m    ��m��
     */
    public void heapSort(int[] data, int m) {
        int length = data.length;
        for (int i = length; i > length - m; i--) {
            createHeap(data, i);
            if (i == length - m - 1) {
                System.out.println(data[0] + "\t");
                break;
            }
        }
    }

    /**
     * ������
     *
     * @param data   ����
     * @param length ���ѳ���
     */
    private void createHeap(int[] data, int length) {
        int start = length / 2 - 1;
        int t;
        for (int i = start; i >= 0; i--) {
            int left = 2 * i + 1;//���ӽڵ��±�
            int right = 2 * i + 2;//���ӽڵ��±�
            //�ҳ��ӽڵ��д����
            if (left < length && right < length && data[left] < data[right]) {
                left = right;
            }
            //�ӽڵ��븸�ڵ�Ƚ�
            if (left < length && data[i] < data[left]) {
                t = data[i]; data[i] = data[left]; data[left] = t;//��������
            }
        }
    }
}
