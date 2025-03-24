import java.util.*;

class Main {
    public static void main(String[] args) {
        int arr[] = {2,4,5,6,2,4};
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length; i++){
            if(set.contains(arr[i])){
                System.out.println(arr[i]);        
            }
            set.add(arr[i]);
        }
    }
}
