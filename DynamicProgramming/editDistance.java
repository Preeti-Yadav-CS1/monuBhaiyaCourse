public class editDistance {
    public static void main(String[] args) {
        String word1= "food";
        String word2= "monkey";

        int result= operation(word1, word2, 0, 0);
        System.out.println(result);
    }
    public static int operation(String word1, String word2, int word1Index, int word2Index){
        if(word1Index==word1.length()){
            return word2.length()-word2Index;
        }
        if(word2Index==word2.length()){
            return word1.length()-word1Index;
        }
        int ans=0;
        if(word1.charAt(word1Index)== word2.charAt(word2Index)){
            ans+=operation(word1, word2, word1Index+1, word2Index+1);
        }else{
            int insert= operation(word1, word2, word1Index+1, word2Index+1);
            int delete= operation(word1, word2, word1Index+1, word2Index);
            int replace= operation(word1, word2, word1Index+1, word2Index+1);
            ans+=Math.min(insert, Math.min(delete, replace));
        }
        return ans;
    }
}
