package sort;

/**
 * 插入排序
 * 稳定
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Sort.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

        }
    }
}
