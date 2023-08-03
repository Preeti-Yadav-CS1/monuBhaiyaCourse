import java.util.*;
public class zeroOneMst {
    private HashMap<Integer, List<Integer>> map= new HashMap<>();
    public zeroOneMst(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new ArrayList<Integer>());
        }
    }
    public void addEdge(int v1, int v2){
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }
    public class Pair{
        int vertex;
        int acqVertex;
        int cost;
        Pair(int vertex,int acqVertex,  int cost){
            this.vertex=vertex;
            this.acqVertex=acqVertex;
            this.cost= cost;
        }
        public String toString(){
            return this.vertex+" "+this.acqVertex+" @ "+this.cost;
        }
    }
    public int primsAlgo(){
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

            for(int neighbour=1;neighbour<=map.size();neighbour++){
                if(!visited.contains(neighbour)){
                    int cost=0;
                    if(map.get(remove.vertex).contains(neighbour))
                        cost=1;
                    Pair newPair= new Pair(neighbour, remove.vertex, cost);
                    pq.add(newPair);
                }
            }
        }
        return finalCost;
    }
    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        try{
            int n=scanner.nextInt();
            int m= scanner.nextInt();
            zeroOneMst mst= new zeroOneMst(n);
            for(int i=0;i<m;i++){
                int v1= scanner.nextInt();
                int v2= scanner.nextInt();
                mst.addEdge(v1, v2);
            }
            mst.primsAlgo();
        }finally{
            scanner.close();
        }
        
    }
}
