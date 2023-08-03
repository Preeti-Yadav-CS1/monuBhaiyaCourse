package tree;

public class BST {
    public class Node{
        int val;
        Node left;
        Node right;
    }
    private Node root;
    public BST(int []in){
       CreateTree(in,0, in.length-1);

    }
    private void CreateTree(int[]n, int si, int ei){
        if(si>ei){

        }
        int mid= (si+ei)/2;
        Node nn= new Node();
        nn.val= n[mid];
        nn.left=CreateTree(n,si,mid-1);
        nn.right= CreateTree(n,mid+1, ei);
    }
    public static void main(String[] args) {
        
    }

}
