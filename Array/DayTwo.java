import java.util.*;
class DayTwo{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
        int minF= scanner.nextInt();
        int maxF= scanner.nextInt();
        int step= scanner.nextInt();
        for(int i=minF; i<=maxF;i+=step){
            int c=5*(i-32)/9;
            System.out.println(i+" "+c);
        }
        }
        finally{
            scanner.close();
        }
    }
}
