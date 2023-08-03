public class minFallingPath {
    public static void main(String[] args) {
        int arr[][]= {{2,1,3}, {6,5,4}, {7,8,9}};
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            result=Math.min(result,fallingPathSum(arr, 0 , i));
        }
        System.out.println(result);
    }
    public static int fallingPathSum(int[][] arr, int i, int j){
        if(j<0 ||j>=arr[0].length)
            return Integer.MAX_VALUE;

        if(i==arr.length-1)
            return arr[i][j];

        int a= fallingPathSum(arr, i+1, j-1);
        int b= fallingPathSum(arr, i+1, j);
        int c= fallingPathSum(arr, i+1, j+1);
        return arr[i][j]+Math.min(a, Math.min(b,c));
    }
}
