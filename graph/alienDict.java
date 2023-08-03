import java.util.*;

public class alienDict {
    public class Solution {
        /**
         * @param words: a list of words
         * @return: a string which is correct order
         */
        public String alienOrder(String[] words) {
            // Write your code here
            HashMap<Character, ArrayList<Character>> map= new HashMap<>();
            for(int i=0;i<words.length;i++){
                String word= words[i];
                for(int j=0;j<word.length();j++){
                    if(!map.containsKey(word.charAt(j)))
                        map.put(word.charAt(j), new ArrayList<>());
                }
            }

            for(int i=0;i<words.length-1;i++){
                String str= words[i];
                String str2= words[i+1];
                if(str.startsWith(str2) && str.length()> str2.length())
                    return "";
                for(int j=0;j<Math.min(str.length(), str2.length());j++){
                    if(str.charAt(j)!=str2.charAt(j)){
                        map.get(str.charAt(j)).add(str2.charAt(j));
                        break;
                    }
                }
            }

            return topologicalString(map);

        }
        public int[] inDegree(HashMap<Character, ArrayList<Character>> map){
            int [] inArray= new int[26];
    
            for(char key: map.keySet()){
                for(char neighbour: map.get(key)){
                    inArray[neighbour-'a']++;
                }
            }
    
            return inArray;
        }

        public String topologicalString(HashMap<Character, ArrayList<Character>> map){
            int[] inArray= inDegree(map);
            StringBuilder sb= new StringBuilder();
            Queue<Character> queue= new LinkedList<>();
            for(char ch: map.keySet()){
                if(inArray[ch-'a']==0){
                    queue.add(ch);
                }
            }

            int count=0;
            while(!queue.isEmpty()){
                char ch= queue.remove();
                count++;
                sb.append(ch);
                for(char neighbour: map.get(ch)){
                    inArray[neighbour-'a']--;
                    if(inArray[neighbour-'a']==0){
                        queue.add(neighbour);
                    }
                }
            }

            return count==map.size()? sb.toString():"";
        }
    }
}
