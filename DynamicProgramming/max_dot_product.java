public class max_dot_product {
    public static void main(String[] args) {
        int [] nums1= {2,1,-1,5};
        int[] nums2= {3,0,-6};
        // int ans= productRecursion(nums1, nums2, 0 , 0);
        int[][] dp= new int[nums1.length][nums2.length];

        int ans= productDP(nums1, nums2, 0, 0, dp, true);
        System.out.println(ans);
    }

    public static int productRecursion(int[] nums1, int[] nums2, int i, int j, boolean flag){
        if(i==nums1.length || j==nums2.length){
            if(flag)
                return 0;
            else
                return -10000000;
        }

        int dot= nums1[i]*nums2[j]+ productRecursion(nums1, nums2, i+1, j+1,true);

        //empty subsequence creation calls
        int fd= productRecursion(nums1, nums2, i+1, j, false);
        int sd= productRecursion(nums1, nums2, i, j+1, false);
        return Math.max(nums1[i]*nums2[j], Math.max(dot, Math.max(fd, sd)));
    }

    public static int productDP(int nums1[], int nums2[], int i, int j, int[][] dp, boolean flag){
        if(i==nums1.length || j==nums2.length){
            if(flag)
                return 0;
            else
                return -10000000;
        }
        if(dp[i][j]!=-1000_000_00)
            return dp[i][j];

        int ans= nums1[i]*nums2[j]+ productDP(nums1, nums2, i+1, j+1, dp, true);
        int fd= productDP(nums1, nums2, i+1, j, dp, false);
        int sd= productDP(nums1, nums2, i, j+1, dp, false);
        return dp[i][j]= Math.max(nums1[i]*nums2[j], Math.max(ans, Math.max(fd, sd)));
    }

    public static int productBU(int[]nums1, int[] nums2){
        int[][] dp= new int[nums1.length][nums2.length];
        //special case of negative [1,1] [-1,-1]
        int spCase= Integer.MIN_VALUE;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length; j++){
                int ans=nums1[i-1]*nums2[j-1];
                int fd= dp[i-1][j];
                int sd= dp[i][j-1];
                dp[i][j]= Math.max(nums1[i-1]*nums2[j-1], Math.max(ans, Math.max(fd, sd)));
                spCase= Math.max(spCase, nums1[i-1]*nums2[j-1]);
            }
        }

        return dp[nums1.length][nums2.length]==0 ? spCase: dp[nums1.length][nums2.length];
    }
}
