public class fibonacciRecursion{
    public static int fibo(int n){
        if(n==0 || n==1)
            return n;
        int fib1= fibo(n-1);
        int fib2= fibo(n-2);
        return fib1+fib2;
    }

    //  top down using dynamic programming
    //  memoization
    public static int fiboTopDown(int n, int[]dp){
        if(n==0 ||n==1)
            return n;
        
        if(dp[n]!=0)
            return dp[n];
    
        int fibo1= fiboTopDown(n-1, dp);
        int fibo2= fiboTopDown(n-2, dp);

        return dp[n]=fibo1+fibo2;

    }

    //  bottom up approach
    //  tabulation
    public static int fiboBottomUp(int n){//iterative method
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n+1];
    }

    public static void main(String[] args) {
        int n= 20;
        // int dp[] = new int[n+1];
        // int result= fiboTopDown(n,dp);
        int result= fiboBottomUp(n);
        System.out.println(result);
    }
}