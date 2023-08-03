public class coinChangeII {
    public static void main(String[] args) {
        int coins[]= {1,2,5};
        int amount=5;
        int ways= noOfWays(coins, amount, 0);
        System.out.println(ways);
    }

    //recursion approach
    public static int noOfWays(int[] coins, int amount, int idx){
        if(amount==0){
            return 1;
        }
        if(idx==coins.length){
            return 0;
        }
        int inclusion=0,exclusion=0;
        if(coins[idx]<= amount){
            inclusion= noOfWays(coins, amount-coins[idx], idx);
        }
        exclusion= noOfWays(coins, amount, idx+1);
        return inclusion+exclusion;
    }

    //dp top down approach
    public static int coinChange(int[] coins, int amount){
        int[][]dp= new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }

        for(int i=1; i <=coins.length;i++){
            for(int am=1; am<=amount; am++){
                int inc=0, exc=0;
                if(coins[i-1]<=am)
                    inc= dp[i][am-coins[i-1]];
                exc= dp[i-1][am];
                dp[i][am]= inc+exc;
            }
        }

        return dp[coins.length][amount];
    }
}
