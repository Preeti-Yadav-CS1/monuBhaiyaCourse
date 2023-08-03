import java.util.*;
public class longestCommanSubs {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            String str = "abcde";
            String str2 = "ace";
            int ans = longestCommanSubsequence(str, str2, 0, 0);
            System.out.println(ans);
        }finally{
            scanner.close();
        }
    }

    //recursion apporoach
    public static int longestCommanSubsequence(String s1, String s2, int i, int j){
        int ans=0;
        if(i==s1.length() || j== s2.length()){
            return 0;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            ans= 1 + longestCommanSubsequence(s1, s2, i+1, j+1);
        }
        else{
            int fs= longestCommanSubsequence(s1, s2, i+1, j);
            int ss= longestCommanSubsequence(s1, s2, i, j+1);
            ans = Math.max(fs,ss);
        }
        return ans;
    }
}
