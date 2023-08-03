import java.util.*;

class DayOne{
    
    public static void main(String[] args) {
        
        Scanner scanner= new Scanner(System.in);
        try{
            System.out.println("enter number: ");
            int n= scanner.nextInt();
            int frist=0;
            int second=1;
            for(int i=0; i<=n;i++){
                if(i==0) System.out.print(frist+ " ");
                else if(i==1) System.out.print(second+ " ");
                else{
                    int next= frist+second;
                    frist=second;
                    second= next;
                    System.out.print(next+ " ");
                }
            }
        }
        finally{
            scanner.close();
        }
    }
}
