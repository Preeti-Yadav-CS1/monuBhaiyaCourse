import java.util.*;
public class LinearSearch {
    public static int index(int []arr, int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int[] arr= {2,3,-1,4,7,11,9};
            int result= index(arr,11);
            System.out.println(result);

        }finally{ 
            scanner.close();
        }
    }
}
