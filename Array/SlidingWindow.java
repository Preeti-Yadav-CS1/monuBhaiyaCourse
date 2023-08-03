public class SlidingWindow{
    public static void main(String[] args) {
        int arr[]={1,3,4,2,5,8,9,6,5};
        int k=3;
        System.out.println(slide(arr,k));
    }
    public static int slide(int[]arr, int k){
        int sum=0;
        int ans;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        ans=sum;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i]-arr[i-k];
            ans=Math.max(ans,sum);
        }

        return ans;
    }
}