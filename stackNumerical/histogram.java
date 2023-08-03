package stackNumerical;

import java.util.Stack;
public class histogram {
    public static void main(String[] args) {
        int arr[]= {2,3,5,4,6,1,7};
        int result= area(arr);
        System.out.println(result);

    }
    public static int area(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int maxArea= 0;

        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[i]<arr[st.peek()]){
                int h= arr[st.pop()];
                int r=i;
                if(st.empty()){
                    maxArea= Math.max(maxArea,h*r);
                }else{
                    int l= st.peek();
                    maxArea= Math.max(maxArea, h*(r-l-1));
                }
            }
            st.push(i);
        }
        int r= arr.length;
        while(!st.empty()){
            int h= arr[st.pop()];
            if(st.empty()){
                maxArea= Math.max(maxArea,h*r);
            }else{
                int l= st.peek();
                maxArea= Math.max(maxArea, h*(r-l-1));
            }
        }

        return maxArea;
    }
}
