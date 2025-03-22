Version 1:
Time: O(n) + O(n) + O(n) → 3O(n) → `O(n)`
Space : O(n)
```
class Main {
    public static void main(String[] args) {
        int pos = 0;
        int ar[] = {0,0,1,1,0,1,1,1,0,0};
        int newAr[] = new int[ar.length] ;
        for(int i=0; i<ar.length; i++){
           if(ar[i] == 0){
               newAr[pos] = ar[i];
               pos++;
           }
        }
        for(int i=pos; i<ar.length; i++){
            newAr[i] = 1;
        }
        for(int i=0; i<ar.length; i++){
         System.out.print(newAr[i]);    
        }
    }
}
```
//OP:
`0000011111`

Version 2:
Time: O(n) + O(n) → `O(n)`
Space : `O(1)`
```
class Main {
    public static void main(String[] args) {
        int pos = 0;
        int arr[] = {0,0,1,1,0,1,1,1,0,0};
        int start = 0;
        int end=arr.length -1 ;
    
        if(start<end){
            for(; start < arr.length  ; start++){
                if(arr[start] == 1 && arr[end] == 0)
                {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    end--;
                }
            }
        }
        
        for(int i=0; i< arr.length ; i++){
             System.out.print(arr[i]);
        }
    }
}
```
//OP:
`0000011111`
