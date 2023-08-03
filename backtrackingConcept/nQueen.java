package backtrackingConcept;

import java.util.*;
public class nQueen{
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
    
            solveNQueens(n);

        }finally{
            scanner.close();
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        } 
        nQueens(board,0,result);
        return result;
    }
    
    
    public static void nQueens(char[][]board,int row, List<List<String>> result){
        //base case
        if(row==board.length){
            List<String> possibleResult= resultBuilder(board);
            result.add(possibleResult);
            return;
        }
        
        
        for(int j=0; j<board.length;j++){
            board[row][j]='Q';
            if(isSafe(board,row,j)){
                
                nQueens(board,row+1,result);
                board[row][j]='.';
            }
            board[row][j]='.';
        }
    }
    
    
    private static boolean isSafe(char[][] board,int x,int y){
        for (int row = 0; row < x; row++) {   
            for (int col = 0; col < board.length; col++) {  
                if ((y == col || Math.abs(x - row) == Math.abs(y - col)) && board[row][col] == 'Q') {   
                    return false;
                }
            }
        }
        
        return true;
    }
    private static List<String> resultBuilder(char[][] board){
        List<String> list= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}