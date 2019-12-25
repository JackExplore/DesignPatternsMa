package patterns.strategy;

import java.util.Arrays;

public class Sort<T> {

//    public static void sort(Comparable[] arr){
//        if(arr == null) return;
//
//        int min = 0;
//        for(int i=0; i<arr.length-1; i++){  // -1
//            min = i;
//            for(int j=i; j<arr.length; j++){
//                min = arr[min].compareTo(arr[j]) == -1 ? min : j;
//            }
//            swap(arr, i, min);
//        }
//    }

    public void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void sort(T[] arr, Comparator<T> comparator) {
        if (arr == null) return;

        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {  // -1
            min = i;
            for (int j = i; j < arr.length; j++) {
                min = comparator.compare(arr[min], arr[j]) == -1 ? min : j;
            }
            swap(arr, i, min);
        }
    }


    public static void main(String[] args) {

        Sort<Cat> sort = new Sort();

        Cat[] objs = {new Cat(3, 5), new Cat(5, 1), new Cat(1, 3)};
//        Dog[] objs = {new Dog(2), new Dog(1), new Dog(3)};
//        sort.sort(objs, new DogComparator());
        System.out.println(Arrays.toString(objs));

        sort.sort(objs, new CatWeightComparator());
        System.out.println(Arrays.toString(objs));

        sort.sort(objs, new CatHeightComparator());
        System.out.println(Arrays.toString(objs));

        // 函数式接口，可以使用 lambda 表达式
        sort.sort(objs, (o1, o2) -> {
            if (o1.weight + o1.height < o2.weight + o2.height) return -1;
            else if (o1.weight + o1.height > o2.weight + o2.height) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(objs));

    }

}
