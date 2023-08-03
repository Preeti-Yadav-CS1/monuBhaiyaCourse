public class distinctSubsequence {
    public static void main(String[] args) {
        String str= "rabbbit";
        String str2= "rabit";
        int result= distinct(str, str2,0,0);
        System.out.println(result);
    }
    public static int distinct(String str, String str2, int i, int j){
        if(j== str2.length()){
            return 1;
        }
        if(i==str.length()){
            return 0;
        }
        int inc=0, exc=0;
        if(str.charAt(i)==str2.charAt(j))
            inc=distinct(str, str2, i+1, j+1);
        exc= distinct(str, str2, i+1, j);

        return inc+exc;
    }
}
