import java.util.*;
public class zeroOneUpdate {
    static TreeSet<Integer>[]arr;
    static TreeSet<Integer>visited;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        arr= new TreeSet[n];
        for(int i=0;i<n;i++){
            arr[i]= new TreeSet<>();
        }

        for(int i=0;i<m;i++){
            int a= scanner.nextInt()-1;
            int b=scanner.nextInt()-1;
            arr[a].add(b);
            arr[b].add(a);
        }
        visited=new TreeSet<>();
        //graph print check
        // for(HashSet<Integer> a: arr){
        //     System.out.println(a);
        // }
        for(int i=0;i<n;i++)
            visited.add(i);

        int ans=0;
        for(int i=0;i<n;i++){
            if(visited.remove(i)){
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans-1);
    }
    public static void dfs(int x){
        List<Integer> ll= new ArrayList<Integer>();
        for(int i: visited){
            if(!arr[x].contains(i)){
                ll.add(i);
            }
        }

        //sb i ke component honge
        for(int i:ll){
            visited.remove(i);
        }

        //jo bache hain unka component ka call lgega
        for(int i:ll){
            dfs(i);
        }
    }
}
