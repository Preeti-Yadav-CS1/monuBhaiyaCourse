public class NumberOfWaysToDivide {
    public static int noCorridor(String s){
        int ts=0;
        int seat=0;
        int plant= 0;
        int mod= (int)((1e9)+7);
        boolean fristC=false;
        long ans=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S'){
                ts++;
                seat++;
            }else if(seat==0){
                plant++;
            }
            if(seat==2){
                if(fristC){
                    ans*=(plant+1);
                    ans%=mod;
                }
                fristC= true;
                seat=0;
                plant=0;
            }
        }
        if(ts==0 ||(ts&1) !=0)
            return 0;
        return (int)ans;
    }
}
