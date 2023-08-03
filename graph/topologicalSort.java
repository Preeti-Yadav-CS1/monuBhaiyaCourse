import java.util.*;
public class topologicalSort {
    HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public topologicalSort(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight); //v1----> v2
    }

    public int[] inDegree(){
        int [] inArray= new int[map.size()+1];

        for(int key: map.keySet()){
            for(int neighbour: map.get(key).keySet()){
                inArray[neighbour]++;
            }
        }

        return inArray;
    }

    public void topologicalSortAlgo(){
        int inArray[]= inDegree();
        Queue<Integer> queue= new LinkedList<>();
        for(int i=1;i<inArray.length;i++){
            if(inArray[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int remove= queue.remove();
            System.out.print(remove+" ");
            for(int neighbour: map.get(remove).keySet()){
                inArray[neighbour]--;
                if(inArray[neighbour]==0)
                    queue.add(neighbour);
            }
        }
        System.out.println();
    }

    public boolean cycleGraph(){
        int inArray[]= inDegree();
        Queue<Integer> queue= new LinkedList<>();
        for(int i=1;i<inArray.length;i++){
            if(inArray[i]==0){
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int remove= queue.remove();
            count++;
            for(int neighbour: map.get(remove).keySet()){
                inArray[neighbour]--;
                if(inArray[neighbour]==0)
                    queue.add(neighbour);
            }
        }
        return map.size()!=count;
    }
    public static void main(String[] args) {
        topologicalSort t = new topologicalSort(8);
		t.addEdge(1, 2,0);
        // t.addEdge(1, 3, 0);
		t.addEdge(2, 4,0);
		t.addEdge(3, 1,0);
		t.addEdge(3, 2,0);
		t.addEdge(4, 5,0);
		t.addEdge(4, 6,0);
		t.addEdge(5, 6,0);
		t.addEdge(7, 8,0);
        System.out.println(Arrays.toString(t.inDegree()));
        t.topologicalSortAlgo();
		System.out.println(t.cycleGraph());
    }
}
