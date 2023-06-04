package template;

import java.util.Arrays;

public class BinarySearch {

    public static int findElement(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findElementLessOrEqual(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 12, 19, 39};
        System.out.println(findElement(arr, 19));
        System.out.println(findElementLessOrEqual(arr, 11));
    }

}
