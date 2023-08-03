import java.util.*;

public class mXORele {
    public static class Pair{
        int xi;
        int mi;
        int qi;
        Pair(int xi, int mi, int qi){
            this.xi=xi;
            this.mi= mi;
            this.qi=qi;
        }
    }
    public static class Node{
        Node zero;
        Node one;
        
    }
    public static void insert(Node root, int val){
        Node curr= root;
        for(int i=31;i>=0;i--){
            if((val&(1<<i))==0){
                if(curr.zero!=null){
                    curr= curr.zero;
                }else{
                    Node newNode= new Node();
                    curr.zero= newNode;
                    curr= newNode;
                }
            }else{
                if(curr.one!=null){
                    curr= curr.one;
                }else{
                    Node newNode= new Node();
                    curr.one= newNode;
                    curr= newNode;
                }
            }
        }
    }
    public static int getMaxXor(Node root, int val){
        int num=0;
        Node curr= root;
        for(int i=31;i>=0;i--){
            int bit= (val &(1<<i));
            if(bit==0){
                if(curr.one!=null){
                    num+=(1<<i);
                    curr= curr.one;
                }else{
                    curr= curr.zero;
                }
            }else{
                if(curr.zero!=null){
                    num+=(1<<i);
                    curr= curr.zero;
                }else{
                    curr= curr.one;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int arr[]= {5,2,4,6,6,3};
        Arrays.sort(arr);
        int[][] query= {{12,4},{8,1},{6,3}};
        Pair []p= new Pair[query.length];
        for(int i=0;i<query.length;i++){
            p[i]= new Pair(query[i][0], query[i][1],i);
        }
        Arrays.sort(p, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2){
                return o1.mi-o2.mi;
            }
        });
        int[] ans= new int[p.length];
        int j=0;
        Node root= new Node();
        for(int i=0;i<p.length;i++){
            while(j<arr.length && arr[j]<=p[i].mi){
                insert(root, arr[j]);
                j++;
            }
            //calculate ans
            if(j==0){
                ans[p[i].qi]=-1;
            }
            else{
                ans[p[i].qi]= getMaxXor(root, p[i].xi);
            }
        }
        for(int num:ans){
            System.out.println(num);
        }
    }
}
