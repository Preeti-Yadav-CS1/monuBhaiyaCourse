import java.util.*;
public class Array {
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        //declaration of arrays
        Scanner scanner= new Scanner(System.in);
        try{
            //java is call by value
            //there is no creation of new array;
            // int[] arr= new int[5];
            //update
            // for(int i=0;i<arr.length;i++){
            //     arr[i]= scanner.nextInt();
            // }
            int [] arr={5,3,7,-7,2};
            int [] other={-5,-3,-7,-2};
            // display(arr);
            int temp[]= arr;
            arr=other;
            other= temp;
            // Swap(arr,other);
            display(arr);
        }
        finally{
            scanner.close();
        }

    }
    public static void Swap(int []a, int[] b){
        int temp[]= a;
        a=b;
        b= temp;

    }
}
