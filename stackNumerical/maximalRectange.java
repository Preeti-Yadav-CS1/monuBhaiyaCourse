package stackNumerical;
import java.util.Stack;
public class maximalRectange {
    public static void main(String[] args) {
        // int[][]matrix=[[],[],[],[]];
        // int [] ans= new int[matrix[0].length];


        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]=='1'){
        //             ans[j]++;

        //         }else{
        //             ans[j]=0;
        //         }
        //     }
        //     area= Math.max()
        // }
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
