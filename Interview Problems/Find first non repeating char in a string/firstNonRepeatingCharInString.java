import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      String str ="aaaaaaaaabbcdddddddddddeaaaabbd";
      System.out.println(findFirstRepeatingChar(str));
    }

    private static char findFirstRepeatingChar(String str) {
        char firstRepeatingChar = '\0';

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return firstRepeatingChar;
    }
}
