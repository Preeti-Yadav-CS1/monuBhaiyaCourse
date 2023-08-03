import java.util.*;
public class PrimsClass {
    private HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public PrimsClass(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight);
        map.get(v2).put(v1, weight);
    }
    public class Pair{
        int vertex;
        int acqVertex;
        int cost;
        Pair(int vertex, int acqVertex, int cost){
            this.vertex=vertex;
            this.acqVertex=acqVertex;
            this.cost= cost;
        }
        public String toString(){
            return this.vertex+" "+this.acqVertex+" @ "+this.cost;
        }
    }
    public void primsAlgo(){
        PriorityQueue<Pair> pq= new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2){
                return o1.cost-o2.cost;
            }
        });
        pq.add(new Pair(1,1,0));
        HashSet<Integer> visited= new HashSet<>();
        int finalCost=0;
        while(!pq.isEmpty()){
            Pair remove= pq.remove();
            if(visited.contains(remove.vertex))
                continue;
            
            visited.add(remove.vertex);
            finalCost+=remove.cost;

            for(int neighbour: map.get(remove.vertex).keySet()){
                if(!visited.contains(neighbour)){
                    Pair newPair= new Pair(neighbour, remove.vertex, map.get(remove.vertex).get(neighbour));
                    pq.add(newPair);
                }
            }
        }
        
        System.out.println(finalCost);
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
            PrimsClass p= new PrimsClass(n);
            int m=scanner.nextInt();
            for(int i=0;i<m;i++){
                int vertex= scanner.nextInt();
                int acqVertex= scanner.nextInt();
                int cost= scanner.nextInt();
                p.addEdge(vertex, acqVertex, cost);
            }
            p.primsAlgo();
        }finally{
            scanner.close();
        }
        
    }
}
