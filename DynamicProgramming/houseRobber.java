// import java.util.*;
public class houseRobber {
    public static void main(String[] args) {
        int nums[]= {2,7,9,3,1};

        //recursion
        // int result= robber(nums,0);
        // System.out.println(result);

        //dp top down
        // int dp[]= new int[nums.length];
        // Arrays.fill(dp,-1);
        // int result = robberTD(nums, 0, dp);
        // System.out.println(result);

        //dp bottom up
        int result =  robberBU(nums);
        System.out.println(result);
    }

    public static int robber(int[]nums, int i){
        if(i>=nums.length)
            return 0;
        int rob= nums[i]+robber(nums, i+2);
        int dontRob= robber(nums, i+1);
        return Math.max(rob,dontRob);
    }

    public static int robberTD(int [] nums, int i, int[]dp){
        if(i>=nums.length)
            return 0;

        if(dp[i]!=-1)
            return dp[i];
        
        int rob = nums[i]+robberTD(nums, i+2, dp);
        int dontRob = robberTD(nums, i+1, dp);

        return dp[i] = Math.max(rob, dontRob);
        
    }

    //approach 1 bottom up
    //start from left to right
    public static int robberBU(int[] nums){
        if(nums.length<2)
            return nums[0];

        int maxTillNow[]= new int[nums.length];

        maxTillNow[0] = nums[0];
        maxTillNow[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            maxTillNow[i]= Math.max(maxTillNow[i-1], maxTillNow[i-2]+nums[i]);
        }

        return maxTillNow[nums.length-1];
    }

    // approach 2 bottom up
    // start from right to left
    
}
