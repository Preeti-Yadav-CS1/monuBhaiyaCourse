package backtrackingConcept;

import java.util.*;
public class palindrome_partitions{
    public static void main(String[] args) {
        String str= "nitin";
        List<String> answer=new ArrayList<>();
        List<List<String>> ans= new ArrayList<>();
        partitions(str, answer,ans);
        System.out.println(ans);

    }
    public static void partitions(String ques, List<String> answer,List<List<String>> ans){

        if(ques.length()==0){
            // System.out.println(answer);
            ans.add(new ArrayList<>(answer));
            return;
        }
        for(int cut=1; cut<=ques.length();cut++){
            String s= ques.substring(0,cut);
            if(isPlindrome(s)){
                answer.add(s);
                partitions(ques.substring(cut), answer,ans);
                answer.remove(answer.size()-1);
            }
            
        }
    }

    public static boolean isPlindrome(String s){
        int i=0;
        int j= s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}