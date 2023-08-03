import java.util.Scanner;

public class cell {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        int x= scanner.nextInt();
        int y= scanner.nextInt();
        int z= scanner.nextInt();
        System.out.println(minCost(2,x,y,z,n));
    }
    public static long minCost(int x, int y, int z, int n){
         long[] dp= new long[n+1];
         for(int i=2;i<dp.length;i++){
            if(i%2==0){
                dp[i]= Math.min(dp[i/2]+x, dp[i-1]+y);
            }else{
                dp[i]= Math.min(dp[i+1]/2+x+z, dp[i-1]+y);
            }
         }
         return dp[n];
    }
}
