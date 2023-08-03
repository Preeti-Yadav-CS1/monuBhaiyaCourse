public class BasicsJava {
    public static void main(String[] args) {
        int n=5;
        // int fact= factorial(n);
        // System.out.println(fact);
        reverse2(n);
    }
    public static int factorial(int n){
        if(n<=1) return 1;
        int fn=factorial(n-1);
        return n*fn;
    }
    public static void reverse(int n){
        if(n<=0) return;
        System.out.println(n);
        reverse(n-1);
    }
    public static void reverse2(int n){
        if(n<=0) return;
        reverse2(n-1);
        System.out.println(n);
    }
}
