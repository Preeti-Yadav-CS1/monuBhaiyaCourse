import java.util.*;
public class bellmanFord {
    HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public bellmanFord(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight);
        map.get(v2).put(v1, weight);
    }

    public void bellmanFordAlgo(int src){
        int distance[]= new int[map.size()];
        for(int i=0;i<distance.length;i++){
            if(i!=src){
                distance[i]= Integer.MAX_VALUE;
            }
        }

        int n= map.size();
        for(int i=0;i<n-1;i++){
            for(int neighbour: map.get(i).keySet()){
                int u= i;
                int v= neighbour;
                int cost= map.get(i).get(neighbour);

                if(distance[u]!=Integer.MAX_VALUE && distance[u]+cost < distance[v]) {
                    distance[v]= distance[u]+cost;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(distance[i]);
        }
    }
    public static void main(String[] args) {
        bellmanFord g= new bellmanFord(7);
        // g.addEdge(0,3,6);
        // g.addEdge(0,1,10);
        // g.addEdge(1,2,7);
        // g.addEdge(2,3,5);
        // g.addEdge(3,4,1);
        // g.addEdge(4,5,4);
        // g.addEdge(6,4,2);
        // g.addEdge(5,6,3);
        g.addEdge(1,4,6);
        g.addEdge(1,2,10);
        g.addEdge(2,3,7);
        g.addEdge(3,4,5);
        g.addEdge(4,5,1);
        g.addEdge(5,6,4);
        g.addEdge(7,5,2);
        g.addEdge(6,7,3);
        g.bellmanFordAlgo(1);
    }
}
