// import javax.sql.rowset.spi.SyncResolver;

// import java.util.*;
public class MinOfArray {
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        // int [] arr={2,3,5,-9,7,-11};
        // int min= Integer.MAX_VALUE;
        // int index=-1;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]<min){
        //         min= arr[i];
        //         index=i;
        //     }
        // }
        // System.out.println(min+" "+index);

        int []arr={2,3,4,5,7};
        int start=0;
        int end= arr.length-1;
        // int frist=arr[start];
        // int last=arr[end];
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
            // frist= arr[start];
            // end= arr[end];
        }

        display(arr);
    }
}
