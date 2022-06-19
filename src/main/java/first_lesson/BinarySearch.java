package first_lesson;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(findMinElement(new int[]{1, 2, 3,4,5}, 5));
        System.out.println(findMinElement(new int[]{1, 2, 3,4}, 3));
    }

    private static int findMinElement(int[] arr, int elem) {
        int first = arr[0];
        int last = arr[arr.length-1];
        int position = (first + last) / 2;
        while ((arr[position] != elem) && (first <= last)){
            if (arr[position] > elem) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        return position;
    }


}
