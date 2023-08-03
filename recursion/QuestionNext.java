// import java.util.*;
public class QuestionNext {
    public static void main(String[] args) {
        String str="abc";
        sequencePrint(str,"");
    }
    public static void sequencePrint(String str,String ans){
       if(str.length()==0){
        System.out.println(ans);
        return;
       }
       
       char ch= str.charAt(0);
       sequencePrint(str.substring(1), ans);
       sequencePrint(str.substring(1), ans+ch);

    }
}
