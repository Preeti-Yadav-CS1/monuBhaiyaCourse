import java.util.*;
public class TrieContact {
     public class Node{
        char ch;
        HashMap<Character, Node> child= new HashMap<>();
        boolean isTreminal= false;
        int count=0;
    }
    private Node root;
    public TrieContact(){
        Node node= new Node();
        node.ch='*';
        this.root= node; 
    }
     public void insert(String word){
        Node curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch); 
                curr.count++;
            }else{
                Node node= new Node();
                node.ch= ch;
                curr.child.put(ch, node);
                node.count=1;
                curr=node;
            }
            
        }
        curr.isTreminal= true;
    }
    public int startsWith(String prefix){
        Node curr= root;
        for(int i=0;i<prefix.length();i++){
            char ch= prefix.charAt(i);
            if(!curr.child.containsKey(ch)){
               return 0;
            }
            curr= curr.child.get(ch);
        }
        return curr.count;
    }
    public static void main(String[] args) {
        TrieContact t= new TrieContact();
        t.insert("hack");
        t.insert("hackerrank");
        System.out.println(t.startsWith("hac"));
        System.out.println(t.startsWith("hak"));
    }
}
