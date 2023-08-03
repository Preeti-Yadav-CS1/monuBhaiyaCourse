import javax.naming.spi.DirStateFactory.Result;

public class minfallingPathII {
    public static void main(String[] args) {
        int arr[][]= {{1,2,3}, {4,5,6}, {7,8,9}};
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            result=Math.min(result,fallingPathSum(arr, 0 , i));
        }
        System.out.println(result);
    }
    public static int fallingPathSum(int[][] arr, int i, int j){
        int result= Integer.MAX_VALUE;
        if(i==arr.length-1)
            return arr[i][j];

        for(int col=0;col<arr[0].length;i++){
            if(col!=j){
                result=Math.min(result, fallingPathSum(arr, i+1, col));
            }
        }
        return result+arr[i][j];
    }
}
