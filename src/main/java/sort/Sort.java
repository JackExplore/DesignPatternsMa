package sort;

import java.util.Arrays;

/**
 * 1. 当 n 较小时，采用 直接插入排序 或 直接选择排序
 * 2. 若初始状态基本有序，采用 直接插入排序 或 冒泡 或 快速排序 为宜
 * 3.
 */


public class Sort {


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 8, 2, 1, 6, 9, 0, 4};
        System.out.println(Arrays.toString(arr));
//        BubbleSort.bubbleSort(arr);
//        SelectionSort.selectionSort(arr);
//        InsertionSort.insertionSort(arr);
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
