// package graph;

import java.util.*;

public class graph_client {
    public static void main(String[] args) {
        basic g= new basic(7);
        g.addEdge(1,4,6);
        g.addEdge(1,2,10);
        g.addEdge(2,3,7);
        g.addEdge(3,4,5);
        g.addEdge(4,5,1);
        g.addEdge(5,6,4);
        g.addEdge(7,5,2);
        g.addEdge(6,7,3);
        // g.display()
        System.out.println(g.hasPath(1, 6, new HashSet<Integer>()));
        g.printAllPath(1,6, new HashSet<>(),"");
        g.Bft();
        g.Dft();
        // System.out.println(g.Dfs(1, 6));
        System.out.println(g.isBipartite());
    }
}
