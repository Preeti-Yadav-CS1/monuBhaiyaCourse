public class question {
    public static void main(String[] args) {
        // Scanner scanner= new Scanner(System.in);
        String str="Hello";
        int i=1;
        while(i<=str.length()){
            for(int j=i;j<=str.length();j++){
                int k= j-i;
                System.out.print(str.substring(k,j)+" ");
            }
            i++;
        }
    }
}
