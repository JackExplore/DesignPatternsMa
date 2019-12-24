package sort;

/***
 * 选择排序
 * 不稳定
 *
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)，只需要一个附加程序单元用于交换
 *
 * 举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null) return;

        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {  // -1
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
//                min = arr[min] < arr[j] ? min : j;
            }
            Sort.swap(arr, i, min);
        }
    }

}
