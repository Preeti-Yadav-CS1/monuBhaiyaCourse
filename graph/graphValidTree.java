// package graph;

import java.util.*;

public class graphValidTree {
    class Solution{
        public boolean validTree(int n, int[][]edge){
            HashMap<Integer, List<Integer>>map= new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(i,new ArrayList<>());
            }

            for(int i=0;i<edge.length;i++){
                int v1= edge[i][0];
                int v2= edge[i][1];
                map.get(v1).add(v2);
                map.get(v2).add(v1);
            }
            return isValid(map);
        }

        public boolean isValid(HashMap<Integer, List<Integer>>map){
            HashSet<Integer> visited= new HashSet<>();
            Stack<Integer> stack= new Stack<>();
            int count=0;
            for(int src: map.keySet()){
                if(visited.contains(src))
                    continue;
                stack.add(src);
                while(!stack.isEmpty()){
                    // 1. remove from stack
                    int remove= stack.pop();
        
                    // 2. Aready visited then ignore
                    if(visited.contains(remove)){
                        continue;
                    }
        
                    count++;
                    // 3. visited
                    visited.add(remove);
        
                    // 5. add unvisited neighbour
                    for(int neighbour: map.get(remove)){
                        if(!visited.contains(neighbour)){
                            stack.push(neighbour);
                        }
                    }
                }
            }
            return count==1;
        }
    }
}
