import java.util.*;
public class RockAndLever {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int test= scanner.nextInt();
            while(test-->0){
                int n= scanner.nextInt();
                int arr[]= new int[n];
                for(int i=0;i<n;i++){
                    arr[i]= scanner.nextInt();
                }
                System.out.println(countPair(arr));
            }
        }finally{
            scanner.close();
        }
    }
    public static long countPair(int[] arr){
        boolean[] visit= new boolean[arr.length];
        long ans=0;
        for(int i=31;i>=0;i--){
            long c=0;
            for(int j=0;j<arr.length;j++){
                if((arr[j] & (1<<i))!=0 && !visit[j]){
                    c++;
                    visit[j]= true;
                }
            }
            ans= ans+(c*(c-1))/2;
        }
        return ans;
    }
}

