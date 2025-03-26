public class Main {
    public static void main(String[] args) {

        String[] data = {"flower", "flow", "flight"};
        System.out.println(findLongestCommonPrefix(data));

    }

    static String findLongestCommonPrefix(String[] stringArray) {
        if (stringArray.length == 0 || stringArray == null) {
            return "";
        }
        return divideAndConquer(stringArray, 0, stringArray.length - 1);
    }

    static String divideAndConquer(String[] stringArr, int start, int end) {
        if (start == end) {
            return stringArr[start];
        }

        int mid = (start + end) / 2;
        String right = divideAndConquer(stringArr, start, mid);
        String left = divideAndConquer(stringArr, mid + 1, end);
        return commonPrefix(right, left);
    }

    private static String commonPrefix(String right, String left) {
        int minLength = Math.min(right.length(), left.length());
        for (int i = 0; i < minLength; i++) {
            if (right.charAt(i) != left.charAt(i)) {
                return right.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }

}
