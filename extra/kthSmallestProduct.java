public class kthSmallestProduct {
    public static void main(String[] args) {
        int[] arr= {-4,-2,0,3};
        int[] nums= {2,4};
        int k=6;
        System.out.println(kthSmallestProductQ(arr , nums, k));
    }
    public static long kthSmallestProductQ(int[] arr, int[] nums, long k) {
        long start= -1000_000_0000l;
        long end= 1000_000_0000l;
        long ans=0;
        while(start<=end){
            long mid=(start+end)/2;
            if(countProduct(arr, nums, mid)>=k){
                ans=mid;
                end= mid-1;
            }else{
                start= mid+1;
            }
        }
        return ans;
    }
    public static long countProduct(int[]arr, int[] nums, long mid){
        long ans=0;
        for(int element: arr){
            if(element>=0){
                long count=0;
                int low=0;
                int high= nums.length-1;
                while(low<=high){
                    int middle=(high+low)/2;
                    if((long)(element)* nums[middle]<=mid){
                        count= middle+1;
                        low= middle+1;
                    }else{
                        high= middle-1;
                    }
                }
                ans+=count;
            }else{
                long count=0;
                int low=0;
                int high= nums.length-1;
                while(low<=high){
                    int middle=(high+low)/2;
                    if((long)(element)* nums[middle]<=mid){
                        count= nums.length-middle;
                        high= middle-1;
                    }else{
                        low= middle+1;
                    }
                }
                ans+=count;
            }
        }
        return ans;
    }
}
