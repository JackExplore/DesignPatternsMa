package sort;

/**
 * 冒泡排序
 * 稳定
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null) return;

        boolean isSort = true;
        for (int i = 0; i < arr.length; i++) {

            isSort = true;

            for (int j = 0; j < arr.length - i - 1; j++) {    // 注意这里的下标
                if (arr[j] > arr[j + 1]) {                      // 还有这里的下标，相邻元素的比较
                    Sort.swap(arr, j, j + 1);
                    isSort = false;
                }
            }

            if (isSort) break;

        }

    }
}
