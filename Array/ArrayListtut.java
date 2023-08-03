import java.util.*;

public class ArrayListtut {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        System.out.println(list);
        // add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
        list.add(1,-300);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.remove(1));
        System.out.println(list.set(1,-9));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();
        // for(int v:list){
        //     System.out.println(v+" ");
        // }
       list.add(3,40);
        System.out.println(list);
    }
}
