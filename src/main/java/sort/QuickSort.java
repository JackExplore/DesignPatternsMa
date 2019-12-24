package sort;

public class QuickSort {


    /**
     * 每个未排序的部分
     * 将第一个元素设为轴心点
     * 存储指数 = 轴心点指数 + 1
     * <p>
     * 从 i = 轴心点指数 + 1  到  最右指数 的遍历
     * 如果 元素[i] < 元素[轴心点，则
     * 交换 i 和 存储指数；
     * 存储指数++；
     * 交换（轴心点，存储指数 -1 ）；
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int pivot = low;
        int temp = low + 1;
        for (int i = temp; i < high; i++) {
            if (arr[i] < arr[pivot]) {
                Sort.swap(arr, temp++, i);
            }
        }
        Sort.swap(arr, pivot, temp - 1);

        quickSort(arr, low, pivot);
        quickSort(arr, pivot + 1, high);

    }
}
