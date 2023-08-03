public class stringpermutation {
    public static void main(String[] args) {
        String str="abc";
        PrintPermutation(str,"");
    }
    public static void PrintPermutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String s1= str.substring(0,i);
            String s2=str.substring(i+1);
            PrintPermutation(s1+s2 ,ans+ch);
            
        }
        
    }
}
