// import java.util.*;
public class RecursionQues2 {
    public static void main(String[] args) {
        int a=5;
        int b=2;
        int result= power(a,b, 1);
        System.out.println(result);
        
        
    }
    public static int power(int a, int b, int res){
        if(b<=0) return res;
        res*=a;
        return power(a,b-1,res);

    }
}
