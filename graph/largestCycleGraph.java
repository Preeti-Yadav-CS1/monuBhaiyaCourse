import java.util.*;
public class largestCycleGraph {
    class Solution {
        public int longestCycle(int[] edges) {
            int inarray[]= new int[edges.length];
            for(int i=0;i<edges.length;i++){
                if(edges[i]!=-1)
                    inarray[edges[i]]++;
            }
            
            boolean visited[]= new boolean[edges.length];
            Queue<Integer> queue= new LinkedList<>();
            for(int i=0;i<edges.length;i++){
                if(inarray[i]==0)
                    queue.add(i);
            }
            
            while(!queue.isEmpty()){
                int remove= queue.remove();
                visited[remove]=true;
                
                int neighbour=edges[remove];
                if(neighbour!=-1){
                    inarray[neighbour]--;
                    if(inarray[neighbour]==0)
                        queue.add(neighbour);
                }
            }
            
            //counting part
            int ans=-1;
            for(int i=0;i<visited.length;i++){
                if(!visited[i]){
                    int count=1;
                    int neighbour=edges[i];
                    visited[i]=true;
                    while(neighbour!=i){
                        visited[neighbour]= true;
                        count++;
                        neighbour=edges[neighbour];
                    }
                    ans=Math.max(ans,count);
                }
            }
            return ans;
        }
    }
}
