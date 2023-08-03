// package graph;

import java.util.*;
public class basic {
    HashMap<Integer, HashMap<Integer, Integer>> map= new HashMap<>();
    public basic(int v){
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int weight){
        map.get(v1).put(v2, weight);
        map.get(v2).put(v1, weight);
    }

    public boolean containsEdge(int v1, int v2){
        return map.get(v1).containsKey(v2);
    }

    public boolean containVertex(int v1){
        return map.containsKey(v1);
    }

    public int numberOfEdges(){
        int sum=0;
        for(int key: map.keySet()){
            sum+=map.get(key).size();
        }
        return sum/2;
    }

    public void removeEdge(int v1, int v2){
        if(map.get(v1).containsKey(v2)){
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }

    public void removeVertex(int v1){
        for(int key: map.get(v1).keySet()){
            map.get(key).remove(v1);
        }
        map.remove(v1);
    }

    public void display(){
        for(int key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
    }

    public boolean hasPath(int src, int dest, HashSet<Integer> visited){
        if(src==dest){
            return true;
        }
        visited.add(src);
        for(int neighbour: map.get(src).keySet()){
            if(!visited.contains(neighbour)){
                boolean ans= hasPath(neighbour, dest, visited);
                if(ans)
                    return true; 
            }
        }
        visited.remove(src);
        return false;
    }
    public void printAllPath(int src, int des, HashSet<Integer> visited, String path){
        if(src==des){
            System.out.println(path+src);
            return;
        }
        visited.add(src);
        for(int neighbour: map.get(src).keySet()){
            if(!visited.contains(neighbour))
               printAllPath(neighbour, des, visited, path+src);
        }
        visited.remove(src);
        return;
    }

    public boolean Bfs(int src, int dest){
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> queue= new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            // 1. remove from queue
            int remove= queue.poll();
            // 2. Aready visited then ignore
            if(visited.contains(remove)){
                continue;
            }
            // 3. visited
            visited.add(remove);

            // 4.self Work
            if(remove==dest)
                return true;
            //add unvisited neighbour
            for(int neighbour: map.get(remove).keySet()){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }

    public boolean Dfs(int src, int dest){
        HashSet<Integer> visited= new HashSet<>();
        Stack<Integer> stack= new Stack<>();
        stack.add(src);
        while(!stack.isEmpty()){
            // 1. remove from stack
            int remove= stack.pop();

            // 2. Aready visited then ignore
            if(visited.contains(remove)){
                continue;
            }

            // 3. visited
            visited.add(remove);

            // 4.self Work
            if(remove==dest)
                return true;

            // 5. add unvisited neighbour
            for(int neighbour: map.get(remove).keySet()){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
        }
        return false;
    }

    public void Bft(){
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> queue= new LinkedList<>();
        for(int src : map.keySet()){ 
            if(visited.contains(src)){
                continue;
            }
            queue.add(src);
            while(!queue.isEmpty()){
                // 1. remove from queue
                int remove= queue.poll();
                // 2. Aready visited then ignore
                if(visited.contains(remove)){
                    continue;
                }
                // 3. visited
                visited.add(remove);

                // 4.self Work
                System.out.println(remove+" ");
                //add unvisited neighbour
                for(int neighbour: map.get(remove).keySet()){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                    }
                }
            } 
            System.out.println();
        }
    }

    public void Dft(){
        HashSet<Integer> visited= new HashSet<>();
        Stack<Integer> stack= new Stack<>();
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
    
                // 3. visited
                visited.add(remove);
    
                // 4.self Work
                System.out.println(remove+" ");
    
                // 5. add unvisited neighbour
                for(int neighbour: map.get(remove).keySet()){
                    if(!visited.contains(neighbour)){
                        stack.push(neighbour);
                    }
                }
            }
            System.out.println();
        }
    }

    class bipartite{
        int vertex;
        int distance;
        public bipartite(int src, int distance){
            this.vertex= src;
            this.distance= distance;
        }
    }
    public boolean isBipartite(){
        HashMap<Integer, Integer> visited= new HashMap<>();
        Queue<bipartite> queue= new LinkedList<>();

        for(int src: map.keySet()){
            if(visited.containsKey(src)){
                continue;
            }

            queue.add(new bipartite(src, 0));
            while(!queue.isEmpty()){
                // 1. remove from queue 
                bipartite remove= queue.poll();

                // 2. Ignore (if already visited)
                if(visited.containsKey(remove.vertex)){
                    if(visited.get(remove.vertex)!=remove.distance){
                        return false;
                    }else{
                        continue;
                    }
                }

                // 3. visited 
                visited.put(remove.vertex, remove.distance);

                // 4. add univisisted neighbour 
                for(int neighbour: map.get(remove.vertex).keySet()){
                    if(!visited.containsKey(neighbour)){
                        queue.add(new bipartite(neighbour,remove.distance+1));
                    }
                }
            }
        }
        return true;
    }
}
