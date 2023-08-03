import java.util.*;
//data structure disjoint set union
public class disjointSetUnion {
    class Node{
        int vertex;
        Node parent;
        int rank;
    }
    HashMap<Integer, Node> map= new HashMap<>();
    public void createSet(int vertex){
        Node node= new Node();
        node.vertex= vertex;
        node.parent= node;
        node.rank=0;
        map.put(vertex,node);
    }

    public int find(int v1){
        Node node= map.get(v1);
        return find(node).vertex;
    }
    private Node find(Node node){
        if(node.parent==node){
            return node;
        }
        // return find(node.parent);
        // path comparasion
        Node nn= find(node.parent);
        nn.parent= node; //main path comparasion
        return node;
    }


    public void union(int v1, int v2){
        Node node1= map.get(v1);
        Node represent1= find(node1);

        Node node2= map.get(v2);
        Node represent2= find(node2);

        if(represent1.rank==represent2.rank){
            represent1.parent= represent2;
            represent2.rank++;
        }else if(represent1.rank<represent2.rank){
            represent1.parent= represent2;
        }else{
            represent2.parent= represent1;
        }
        
    }
}
