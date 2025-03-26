public class Main {
    public static void main(String[] args) {

        String[] data = {"flower", "flow", "flight"};
        System.out.println(findPrefix(data));

    }

    static String findPrefix(String[] stringArray) {
        String prefix = stringArray[0];

        for (int i = 1; i < stringArray.length; i++) {
            String temp = "";
            char[] charArr = stringArray[i].toCharArray();
            for (char c : charArr) {
                if (prefix.indexOf(c) != -1) {
                    temp += c;
                } else {
                    break;
                }
            }
            prefix = temp;
        }
        return prefix;
    }
}
