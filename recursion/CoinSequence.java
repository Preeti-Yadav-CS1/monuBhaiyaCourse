public class CoinSequence {
    public static void main(String[] args) {
        int n=3;
        coin("",n,0);
    }
    public static void coin(String h,int n, int count){

        if(count==n){
            System.out.println(h);
            return;
        }
        if(h.length()==0 || h.charAt(h.length()-1)!='H')
        coin(h+'H',n,count+1);

        coin(h+'T',n, count+1);
    }

}
