// import java.util.*;
public class StringsTut {
    public static void main(String[] args) {
        // Scanner scanner= new Scanner(System.in);
        String s1="Kartik";
        String s2= "Karam";
        if(s1.length()>s2.length()) System.out.println(s1);
        else if(s2.length()>s1.length()) System.out.println(s2);
        else{
            if(s1.length()==s2.length()){
                int start=0;
                while(start!=s1.length()){
                    if(s1.charAt(start)>s2.charAt(start)){
                        System.out.println(s1);
                        break;
                    }else if(s1.charAt(start)<s2.charAt(start)){
                        System.out.println(s2);
                        break;
                    }else start++;
                }
            }
        }
    }
}
