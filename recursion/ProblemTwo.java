import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
        int n=scanner.nextInt();
        int fab=fabonicci(n);
        System.out.println(fab);
        }
        finally{
            scanner.close();
        }
    }
    public static int fabonicci(int n){
        if(n==0||n==1) return n;
       int fib1=fabonicci(n-1);
       int fib2=fabonicci(n-2);
       return fib1+fib2;

    }
}
