public class lis {
    public static void main(String[] args) {
        
    }
    public static int longestContinousSubSeq(int[] nums){
        int[] dp= new int[nums.length];
        dp[0] = nums[0];
        int len=1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]>dp[len-1]){
                dp[i]= nums[i];
                len++;
            }else{
                //dp array is nums[i] se just bade value ka index leke aaye
                int idx= search(dp, 0, len-1, nums[i]);
                dp[idx]= nums[i];
            }
        }

        return len;
    }


    public static int search(int[] dp, int start, int end, int element){
        int ans=0;
        while(start<=end){
            int mid= start+(end+start)/2;

            if(dp[mid]>= element){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
