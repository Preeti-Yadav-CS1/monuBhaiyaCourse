import java.util.*;
public class addPara {
    public static List<Integer> ways(String s){
        if(s.indexOf('+')==-1 && s.indexOf('-')==-1&& s.indexOf('*')==-1 ){
            List<Integer> result= new ArrayList<>();
            result.add(Integer.parseInt(s));
            return result;
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(isOper(ch)){
                List<Integer> left= ways(s.substring(0, i));
                List<Integer> right= ways(s.substring(i+1));
                for(int a:left){
                    for(int b:right){
                        int val= calculatio(a, b, ch);
                        ans.add(val);
                    }
                    
                }
            }
        }
        return ans;
    }
    public static int calculatio(int a, int b, char op){
        if(op=='+'){
            return a+b;
        }else if(op=='-'){
            return a-b;
        }
        return a*b;
    }
    public static boolean isOper(char ch){
        if(ch=='+' ||ch=='-'||ch=='*'){
            return true;
        }
        return false;
    }
}
