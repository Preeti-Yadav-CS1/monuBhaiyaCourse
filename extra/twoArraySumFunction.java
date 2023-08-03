import java.util.*;

public class twoArraySumFunction {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
            long[] a= new long[n];
            for(int i=0;i<a.length;i++){
                long x= scanner.nextInt();
                a[i]= (i+1)*(n-i)*x;

            }
            Long[]b= new Long[n];
            for(int i=0;i<b.length;i++){
                b[i]= scanner.nextLong();
            }
            int mod= 998244353;
            long ans=0;
            Arrays.sort(a);
            Arrays.sort(b, Collections.reverseOrder());
            for(int i=0;i<b.length;i++){
                ans= ans+((a[i]%mod)*b[i]);
                ans%=mod;
            }
            System.out.println(ans%mod);
        }finally{
            scanner.close();
        }
    }
}
