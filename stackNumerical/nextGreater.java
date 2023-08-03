package stackNumerical;

import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class nextGreater{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
            int []arr= new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]= scanner.nextInt();
            }
            int gre[]= new int[n];
            Arrays.fill(gre, -1);
            Stack<Integer> st= new Stack<Integer>();
            for(int i=0;i<n;i++){
                while(!st.empty() && arr[i]>arr[st.peek()]){
                    gre[st.pop()]= arr[i];
                }
                st.push(i);
            }

            for(int i=0;i<n;i++){
                System.out.print(gre[i]+" ");
            }

        }finally{
            scanner.close();
        }
    }
}