public class catlanNumber {
    public static void main(String[] args) {
        
    }
    public int catlan(int n){
        if(n==0 ||n==1){
            return 1;
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            ans= ans+catlan(i-1)*catlan(n-i);
        }
        return ans;
    }
}
