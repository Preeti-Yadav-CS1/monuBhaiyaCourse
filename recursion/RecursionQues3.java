public class RecursionQues3 {
    static int len;
    static int count=-1;
    public static void main(String[] args) {
        int arr[]= {2,3,5,4,1,3,7,3,6};
        int num=3;
        len=arr.length;
        int result= position(arr,num,0);
        System.out.println(result);
    }

    public static int position(int []arr, int num,int i){
        if(i>=arr.length){
            return -1;
        }
        if(arr[i]==num){
            return arr.length-i-1;
        }
        return position(arr, num, i+1);

    }
}
