public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 8, 8, 10}; // sorted
        int target = 6;

        int[] arr = findIndexed(nums, target);
        if (arr != null) {
            System.out.print(arr[0] + " " + arr[1]);
        } else {
            System.out.print("Array doesn't contain target element.");
        }
    }

    private static int[] findIndexed(int[] nums, int target) {
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        if (pos < 0) {
            return null;
        }

        int start = pos, end = pos;

        while (start > 0 && nums[start -1] == target) {
            start -= 1;
        }
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end += 1;
        }

        return new int[]{start, end};

    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;

        if (left > right) {
            return -1;
        } else if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            right = mid - 1;
        }
        if (nums[mid] < target) {
            left = mid + 1;
        }

        return binarySearch(nums, left, right, target);

    }
}
