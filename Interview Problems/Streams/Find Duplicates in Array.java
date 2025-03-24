import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        int arr[] = {2,4,5,6,2,4,6,4};
        Set<Integer> set = new HashSet<>();

        Arrays.stream(arr)
            .filter(num -> !set.add(num))
            .distinct()
            .boxed()
            .forEach(System.out::println);
        
    }
}
