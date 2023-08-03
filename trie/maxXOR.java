// import java.util.*;
public class maxXOR {
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
        Node root= new Node();

        int arr[]={3,10,5,25,2,8};
        for(int num: arr){
            insert(root, num);
        }
       int xor=Integer.MIN_VALUE;
       for(int num:arr){
            xor= Math.max(xor, getMaxXor(root, num));
       }
       System.out.println(xor);
    }
}
