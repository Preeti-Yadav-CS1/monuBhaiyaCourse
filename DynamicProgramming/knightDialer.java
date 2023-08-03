public class knightDialer {
    public static void main(String[] args) {
        int n=2;
        long ans=0;
        for (int index = 0; index < 4; index++) {
            for(int j=0;j<3;j++){
                ans+=count(n-1,index, j);
            }
        }
        System.out.println((int) (ans%1000_000_007));
    }
    public static int count(int n, int cr, int cc){
        if((cr<0 || cc<0 ||cc>=4|| cc>=3)||(cr==3 && cc==0)|| (cr==3&& cc==2) ){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int[] r={-2,-2,2,2,-1,1,-1,1};
        int[] c={-1,1,-1,1,-2,-2,2,2};

        long ans=0;
        for(int i=0;i<c.length;i++){
            ans+=count(n-1, cr+r[i], cc+c[i]);
        }
        return (int) (ans%1000_000_007);
    }
}
