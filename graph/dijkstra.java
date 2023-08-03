// package graph;
import java.util.*;
public class dijkstra {
    HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public dijkstra(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight);
        map.get(v2).put(v1, weight);
    }

    private class dijkstraPair{
        int vertex;
        String path;
        int cost;
        public dijkstraPair(int vertex, String path, int cost){
            this.vertex=vertex;
            this.path= path;
            this.cost= cost;
        }
        @Override
        public String toString(){
            return this.vertex+" via "+ this.path+" @ "+ this.cost;
        }
    }
    public void dijkstraAlgo(){
        PriorityQueue<dijkstraPair> pq= new PriorityQueue<>(new Comparator<dijkstraPair>(){
            public int compare(dijkstraPair o1, dijkstraPair o2){
                return o1.cost-o2.cost;
            }  
        });

        HashSet<Integer> visited= new HashSet<>();
        pq.add(new dijkstraPair(1,"1",0));
        while(!pq.isEmpty()){
            dijkstraPair remove= pq.poll();
            if(visited.contains(remove.vertex))
                continue;

            visited.add(remove.vertex);
            System.out.println(remove);
            for(int neighbour: map.get(remove.vertex).keySet()){
                if(!visited.contains(neighbour)){
                    int cost= remove.cost+ map.get(remove.vertex).get(neighbour);
                    pq.add(new dijkstraPair(neighbour, remove.path+neighbour, cost));

                }
            }
        }
    }
    public static void main(String[] args) {
        dijkstra g= new dijkstra(7);
        g.addEdge(1,4,6);
        g.addEdge(1,2,10);
        g.addEdge(2,3,7);
        g.addEdge(3,4,5);
        g.addEdge(4,5,1);
        g.addEdge(5,6,4);
        g.addEdge(7,5,2);
        g.addEdge(6,7,3);
        g.dijkstraAlgo();
    }
}
