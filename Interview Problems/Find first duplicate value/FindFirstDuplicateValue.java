// Find first duplicate value in a fixed int array,
// where the elements of the array are numbers less than the size of the array.

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 3};
        System.out.println(findFirstDuplicateValue(arr));
    }

    private static int findFirstDuplicateValue(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return Math.abs(arr[i]);
            } else {
                arr[arr[i] - 1] = -arr[arr[i] - 1];
            }
        }
        return -1;
    }
}
