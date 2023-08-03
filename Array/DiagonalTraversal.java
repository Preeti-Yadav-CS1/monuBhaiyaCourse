import java.util.*;
public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        diagonal(arr);
    }
    public static int[] diagonal(int[][]arr){
        int n= arr.length;
        int m= arr[0].length;
        int[] array= new int[m*n];
        int idx=0;
        for(int d=0;d<m+n-1;d++){
            int r=0,c=0;
            if(d<m){
                r=0;
                c=d;
            }else{
                c=m-1;
                r=d-m+1;
            }
            ArrayList<Integer> list= new ArrayList<>();
            while(r<n &&c>=0){
                list.add(arr[r][c]);
                r++;
                c--;
            }
            if(d%2==0){
                for(int i=list.size()-1;i>=0;i--){
                    array[idx]=list.get(i);
                }
            } else{
                    for(int i=0;i<list.size();i++){
                        array[idx]=list.get(i);
                    }
                }
            }
        return array;
    }
}
