public class medianOfSorted{
    public static void main(String[] args) {
        
    }
    public static double findMedian(int []arr, int[] nums){
        int low=0;
        int high= arr.length;
        int n= arr.length;
        int m= nums.length;
        while(low<=high){
            int cut1= (low+high)/2;
            int cut2=(n+m+1)/2-cut1;
            int l1= cut1==0?Integer.MIN_VALUE: arr[cut1-1];
            int r1= cut1==n? Integer.MAX_VALUE: arr[cut1];
            int l2= cut2==0?Integer.MIN_VALUE: nums[cut2-1];
            int r2= cut2==m? Integer.MAX_VALUE: nums[cut2];

            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                high=cut1-1;
            }else{
                low= cut1+1;
            }
        }
        return 0.0;
    }
    public static double findMedianSorted(int[] nums1, int[]nums2){
        if(nums1.length<nums2.length){
            return findMedian(nums1, nums2);
        }
        return findMedian(nums2, nums1);
        
    }
}