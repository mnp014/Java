// For a given sorted array containing negative and positive integers.
// return sorted array containing squares of input array.

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{-4, -2, 0, 1, 3, 5};

        int[] result = getSortedSquaredArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int[] getSortedSquaredArray(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0, right = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[left]) > arr[right]) {
                result[i] = arr[left] * arr[left];
                left++;
            } else if (Math.abs(arr[left]) < arr[right]) {
                result[i] = arr[right] * arr[right];
                right--;
            }
        }

        return result;
    }

}
