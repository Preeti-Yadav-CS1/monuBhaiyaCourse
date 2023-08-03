package backtrackingConcept;

public class LetterTilePossible {
    public static void main(String[] args) {
        String s= "AAB";
        int[] freq= new int[26];
        for(int i=0;i<s.length();i++){
            int idx= s.charAt(i)-'A';
            freq[idx]++;
        }
        // for(int i=0;i<26;i++){
        //     System.out.print(freq[i]+" ");
        // }
        int result=function(freq, ""); 
        System.out.println(result);

    }
    public static int function(int[] freq, String ans){
        // System.out.println(ans);
        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]>=1){
                char ch=(char)(i+'A');
                freq[i]--;
                count+= function(freq, ans+ch)+1;
                freq[i]++;
            }
        }
        return count;
    }
}
