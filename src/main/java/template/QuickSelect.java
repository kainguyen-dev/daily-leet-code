package template;

public class QuickSelect {
    // Find kth the largest element
    // Space O(1)
    // Time O(N)

    public static int quickSelect(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k: " + k);
        }
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int partition = partition(arr, left, right);

        if (partition == k - 1)
            return arr[partition];
        else if (partition < k - 1)
            return quickSelect(arr, partition + 1, right, k);
        else
            return quickSelect(arr, left, partition - 1, k);

    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIdx = left;
        int pivot = arr[right];

        for (int i = left; i <= right; i++) {
            if (arr[i] > pivot) {
                // Swap pivot index and current i
                int temp = arr[i];
                arr[i] = arr[pivotIdx];
                arr[pivotIdx] = temp;
                pivotIdx++;
            }
        }
        // After this all element less than pivot will be on the left
        // Swapping pivot to the final pivot location
        int temp = arr[right];
        arr[right] = arr[pivotIdx];
        arr[pivotIdx] = temp;
        return pivotIdx;
    }

    public static void main(String[] args) {

        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
        System.out.println(quickSelect(array, 1 ));

    }

}
