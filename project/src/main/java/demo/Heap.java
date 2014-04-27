package demo;

/**
 * Created with IntelliJ IDEA.
 * User: wayaya
 * Date: 14-4-23
 * Time: 上午6:51
 */
public class Heap {

    /**
     * 输入数据返回第m大的数
     *
     * @param data 原始数据
     * @param m    第m大
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
     * 创建堆
     *
     * @param data   数据
     * @param length 建堆长度
     */
    private void createHeap(int[] data, int length) {
        int start = length / 2 - 1;
        int t;
        for (int i = start; i >= 0; i--) {
            int left = 2 * i + 1;//左子节点下标
            int right = 2 * i + 2;//右子节点下标
            //找出子节点中大的数
            if (left < length && right < length && data[left] < data[right]) {
                left = right;
            }
            //子节点与父节点比较
            if (left < length && data[i] < data[left]) {
                t = data[i]; data[i] = data[left]; data[left] = t;//交换数据
            }
        }
    }
}
