package MonuBhaiya.recurrenceRelation;

public class powerLogN {
    public static void main(String[] args) {
        int a= 3;
        int b=9;
        int result= powerFunction(a, b);
        System.out.println(result);
    }
    public static int powerFunction(int a, int b){
        if(b==0) return 1;

        int ans= powerFunction(a, b/2);
        ans= ans*ans;
        if(b%2==1){
            ans= ans*a;
        }
        return ans;
    }
}
