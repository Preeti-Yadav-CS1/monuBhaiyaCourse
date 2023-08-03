public class lastOcc {
    public static void main(String[] args) {
        int arr[]= {2,3,5,4,1,3,7,3,6};
        int num=3;
        int result= occ(arr,num,arr.length-1);
        System.out.println(result);
    }
    public static int occ(int[]arr,int num,int i){
        if(i<0){
            return -1;
        }
        if(arr[i]==num){
            return i;
        }
        return occ(arr, num, i-1);
    }
}
