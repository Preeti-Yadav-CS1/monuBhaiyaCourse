import java.util.*;
public class Trie{
    public class Node{
        char ch;
        HashMap<Character, Node> child= new HashMap<>();
        boolean isTreminal= false;
        
    }
    private Node root;
    public Trie(){
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
            }else{
                Node node= new Node();
                node.ch= ch;
                curr.child.put(ch, node);
                curr=node;
            }
            
        }
        curr.isTreminal= true;
    }
    public boolean search(String word){
        Node curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!curr.child.containsKey(ch)){
               return false;
            }
            curr= curr.child.get(ch);
        }
        return curr.isTreminal;
    }
    public boolean startsWith(String prefix){
        Node curr= root;
        for(int i=0;i<prefix.length();i++){
            char ch= prefix.charAt(i);
            if(!curr.child.containsKey(ch)){
               return false;
            }
            curr= curr.child.get(ch);
        }
        return true;
    }
}