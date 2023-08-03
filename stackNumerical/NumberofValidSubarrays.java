package stackNumerical;

import java.util.Stack;
public class NumberofValidSubarrays{
    public static void main(String[] args) {
        int []arr= {1,4,2,5,3};
        int result= validSubarray(arr);
        System.out.println(result);

    }
    public static int validSubarray(int[] arr){
        Stack<Integer> st= new Stack<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[i]<st.peek()){
                st.pop();
            }
            st.push(arr[i]);
            ans+=st.size();
        }
        return ans;
    }
}