package stackNumerical;

import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int nums[]= {1,3,-1,-3,5,3,6,7};
        int k=3;
        int []arr= windowMaximum(nums, k);
        System.out.println(arr);

    }
    public static int[] windowMaximum(int[] arr, int k){
        int n= arr.length;
        int[] ans= new int[n-k+1];
        Deque<Integer> dq= new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty()&& arr[i]>arr[dq.getLast()]){
                dq.removeLast();

            }
            dq.add(i);
        }
        int index=0;
        for(int i= k;i<arr.length;i++){
            while(!dq.isEmpty()&& arr[i]>arr[dq.getLast()]){
                dq.removeLast();

            }
            dq.add(i);
            if(dq.isEmpty()&& dq.getFirst()==i-k){
                dq.removeFirst();
            }
            ans[index++]=dq.getFirst();
            
        }

        return ans;
    }
}
