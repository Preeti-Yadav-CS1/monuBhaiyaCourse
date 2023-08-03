public class DayTwoRecursion {
    public static void main(String[] args) {
        int n=5;
        int fab=fabonicci(n,0,1);
        System.out.println(fab);
    }
    static int count=2;
    public static int fabonicci(int n, int a, int b){
        if(count==n) return a+b;
        count+=1;
        return fabonicci(n, b,a+b);
    }
}
