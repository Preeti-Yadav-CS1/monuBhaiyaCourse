import java.util.*;
public class lcsDP {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            String s1 = "abcde";
            String s2 = "ace";
            // int[][] dp= new int[s1.length()][s2.length()];
            // for(int [] a: dp){
            //     Arrays.fill(a, -1);
            // }
            // int ans= lcsTD(s1, s2, 0, 0, dp);
            int ans= lcsBU(s1, s2);
            System.out.println(ans);
        }finally{
            scanner.close();
        }
    }

    public static int lcsTD(String s1, String s2, int i, int j, int[][]dp){
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans= 1 + lcsTD(s1, s2, i+1, j+1, dp);
        }
        else{
            int fs= lcsTD(s1, s2, i+1, j, dp);
            int ss= lcsTD(s1, s2, i, j+1, dp);
            ans = Math.max(fs,ss);
        }

        return dp[i][j]= ans ;
    }
    public static int lcsBU(String s1, String s2){
        int[][] dp= new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length(); j++){
                int ans=0;
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans= 1 + dp[i-1][j-1];
                }
                else{
                    int fs= dp[i][j-1];
                    int ss= dp[i-1][j];
                    ans = Math.max(fs,ss);
                }
                dp[i][j]= ans;
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
