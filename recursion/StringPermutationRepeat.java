public class StringPermutationRepeat {
    public static void main(String[] args) {
        String str="abca";
        PrintPermutation(str,"");
    }
    public static void PrintPermutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            boolean f= false;
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)==ch){
                    f=true;
                    break;
                }
            }
            if(f==false){
                String s1= str.substring(0,i);
                String s2=str.substring(i+1);
                PrintPermutation(s1+s2 ,ans+ch);
            }
        }
    }
}
