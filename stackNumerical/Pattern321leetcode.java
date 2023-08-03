package stackNumerical;

import java.util.Stack;
public class Pattern321leetcode {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4};
        boolean result= pattern(arr);
        System.out.println(result);

    }
    public static boolean pattern(int []arr){
        // boolean flag= false;
        int[]minim= new int[arr.length];
        minim[0]= arr[0];
        for(int i=1;i<arr.length;i++){
            minim[i]= Math.min(minim[i-1], arr[i]);
        }

        Stack<Integer> st= new Stack<>();
        for(int j=arr.length-1;j>=0;j--){
            int i= minim[j];
            while(!st.empty()&& i>=arr[st.peek()]){
                st.pop();
            }
            if(!st.empty() && arr[j]>arr[st.peek()]){
                return true;
            }
            st.push(i);
        }
        return false;
        
    }
}
