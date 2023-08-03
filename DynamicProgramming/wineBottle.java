public class wineBottle {
    public static void main(String[] args) {
        int[] wine= {2,3,5,1,4};
        System.out.println(maxProfit(wine, 0, wine.length-1, 1));
        System.out.println(maxProfitBU(wine));
    }
    public static int maxProfit(int[] wine, int i, int j , int year){
        if(i>j)
            return 0;
        int fst= wine[i]*year +maxProfit(wine, i+1, j, year+1);
        int snd= wine[j]*year + maxProfit(wine, i, j-1, year+1);
        return Math.max(fst, snd);
    }
    public static int maxProfitBU(int [] wine){
        int n= wine.length;
        int dp[][]= new int[n][n];
        // sale on 5th year 
        for(int i=0;i<n;i++){
            dp[i][i]= wine[i]*n;
        }
        int year=n-1;
        for(int dia= 1;dia<n;dia++){
            for(int j=dia;j<n;j++){
                int i= j-dia;
                int fst= wine[i]*year + dp[i+1][j];
                int snd= wine[j]*year + dp[i][j-1];
                dp[i][j]=Math.max(fst, snd);
            }
            year--;
        }
        return dp[0][n-1];
    }
}
