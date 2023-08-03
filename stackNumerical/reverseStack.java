package stackNumerical;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<Integer>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }
    public static void reverse(Stack<Integer> st ){
        if(st.empty()){
            return;
        }
        int q= st.pop();
        reverse(st);
        Insert(st, q);  
    }
    public static void Insert(Stack<Integer> st, int item){
        if(st.empty()){
            st.push(item);
        }else{
            int q= st.pop();
            Insert(st, item);
            st.push(q);
        }
    }
}
