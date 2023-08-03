import java.util.*;

public class prims {
    HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public prims(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight);
        map.get(v2).put(v1, weight);
    }
    public class Pair implements Comparable<Pair>{
        int vertex;
        int cost;
        public Pair(int vertex, int cost){
            this.vertex= vertex;
            this.cost= cost;
        }

        @Override
        public int compareTo(Pair p){
            return this.cost- p.cost;
        }
    }

    public void primsAlgo(){
        HashSet<Integer> visited= new HashSet<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>();

        pq.add(new Pair(0,0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Pair remove= pq.remove();
            if(visited.contains(remove.vertex)){
                continue;
            }
            visited.add(remove.vertex);
            finalCost+= remove.cost;

            for(int neighbour: map.get(remove.vertex).keySet()){
                pq.add(new Pair(neighbour, map.get(remove.vertex).get(neighbour)));
            }
        }
        System.out.println(finalCost);
    }
    public static void main(String[] args) {
        prims g= new prims(7);
        g.addEdge(1,4,6);
        g.addEdge(1,2,10);
        g.addEdge(2,3,7);
        g.addEdge(3,4,5);
        g.addEdge(4,5,1);
        g.addEdge(5,6,4);
        g.addEdge(7,5,2);
        g.addEdge(6,7,3);
        g.primsAlgo();
    }
}
