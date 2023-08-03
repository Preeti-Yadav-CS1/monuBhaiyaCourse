package stackNumerical;
import java.util.Stack;
public class InsertDown {
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<Integer>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st);
        Insert(st, -3);
        System.out.println(st);
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
