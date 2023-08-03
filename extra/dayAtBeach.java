import java.util.*;
public class dayAtBeach {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= scanner.nextInt();
            }
            int[]left= new int[n+1];
            left[0]= Integer.MIN_VALUE;
            for(int i=1;i<n+1;i++){
                left[i]= Math.max(left[i-1], arr[i-1]);
            }
            int[] right= new int[n+1];
            right[n]=Integer.MAX_VALUE;
            for(int i=n-1;i>=0;i--){
                right[i]= Math.min(right[i+1], arr[i]);
            }
            int part=0;
            for(int i=0;i<n;i++){
                if(left[i]<=right[i]){
                    part++;
                }
            }
            System.out.println(part);
        }finally{
            scanner.close();
        }
    }
}
