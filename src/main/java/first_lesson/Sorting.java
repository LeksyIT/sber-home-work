package first_lesson;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 10, 7, 4, 3, 2, 1, 100, 0};
        int[] arr1 = new int[]{6, 5, 3, 4, 8, 7, 2, 1};
        System.out.println("arr - shakerSorting:     " + Arrays.toString(shakerSorting(arr)));
        System.out.println("arr - bubbleSorting:     " + Arrays.toString(bubbleSorting(arr)));
        System.out.println("arr - combSort:          " + Arrays.toString(combSort(arr)));
        System.out.println("arr - insertion:         " + Arrays.toString(insertion(arr)));
        System.out.println("arr - selectionSort:     " + Arrays.toString(selectionSort(arr)));
        System.out.println("------------------------------------------");
        System.out.println("arr1 - shakerSorting:    " + Arrays.toString(shakerSorting(arr1)));
        System.out.println("arr1 - bubbleSorting:    " + Arrays.toString(bubbleSorting(arr1)));
        System.out.println("arr1 - combSort:         " + Arrays.toString(combSort(arr1)));
        System.out.println("arr1 - insertion:        " + Arrays.toString(insertion(arr1)));
        System.out.println("arr1 - selectionSort:    " + Arrays.toString(selectionSort(arr1)));
    }

    private static int[] bubbleSorting(int[] arr) {
        boolean checker = true;
        int i = 0;
        while (checker && i < arr.length) {
            i++;
            checker = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    checker = true;
                    int valJ = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = valJ;
                }
            }
        }

        return arr;
    }

    private static int[] shakerSorting(int[] arr) {
        boolean checker = true;
        int first = 0;
        int last = arr.length - 1;
        while (first <= last && checker) {
            checker = false;
            for (int i = first; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    checker = true;
                    int valJ = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = valJ;
                }
            }
            last--;
            for (int i = last; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    int valJ = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = valJ;
                }
            }
            first++;
        }
        return arr;
    }

    private static int[] combSort(int[] arr) {
        int gap = arr.length;
        while (gap >= 1) {
            gap = (int) (gap / 1.247330950103979);
            int i = 0;
            while (i + gap < arr.length) {
                if (arr[i] > (arr[i + gap])) {
                    int t = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = t;
                }
                i++;
            }
        }
        return arr;
    }

    private static int[] insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int valJ = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = valJ;
                j--;
            }
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            arr[i] = min;
        }
        return arr;
    }

}
