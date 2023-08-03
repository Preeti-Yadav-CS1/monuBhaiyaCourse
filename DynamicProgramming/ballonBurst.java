public class ballonBurst {
    public static void main(String[] args) {
        int []nums= new int[5];
        int arr[]= new int[nums.length+2];
        arr[0]= arr[arr.length-1]=1;
        for(int i=1;i<arr.length-1;i++){
            arr[i]= nums[i-1];
        }
        System.out.println(burst(arr, 0, arr.length-1));
    }
    public static int burst(int []arr, int s, int e){
        if(s+1==e){
            return 0;
        }
        int ans= Integer.MIN_VALUE;
        for(int k=s+1;k<e;k++){
            int left= burst(arr, s, k);
            int right= burst(arr, k, e);
            int self= arr[s]*arr[k]*arr[e];
            ans= Math.max(ans, self+left+right);
        }
        return ans;
    }
    public static int burDp(int[]arr){
        int[][]dp= new int[arr.length][arr.length];
        for(int slide=2; slide<dp.length;slide++){
            for(int j= slide;j<dp.length;j++){
                int i=j-slide;
                int ans= Integer.MIN_VALUE;
                for(int k=i+1;k<j;k++){
                    int left= dp[i][k];
                    int right= dp[k][j];
                    int self= arr[i]*arr[k]*arr[j];
                    ans= Math.max(ans, self+left+right);
                }
                dp[i][j]= ans;
            }
        }
        return dp[0][dp.length-1];
    }
}
