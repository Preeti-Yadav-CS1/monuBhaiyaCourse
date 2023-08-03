// import java.util.*;
public class RecursionQues{
    //if last statement is recursive call and imediate return
    public static void main(String[] args) {
        int n=5;
        int result= factorial(n,1);
        System.out.println(result);
    }
    //using tail recursion
    public static int factorial(int num,int count){
        if(num<=1) return count;
        count*=num;
        return factorial(num-1, count);
    }
    // public static void reverse(int n){
    //     if(n<=0) return;
    //     System.out.println(n);
    //     reverse(n-1);
    // }
}