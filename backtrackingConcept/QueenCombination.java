package backtrackingConcept;

public class QueenCombination {
    public static void main(String[] args) {
        int n=4;
        int q=2;
        boolean[] board= new boolean[n];
        function(board,q,0,"",0);
    }
    public static void function(boolean[] board, int q, int qpsf, String ans, int idx){
        if(qpsf==q){
            System.out.println(ans);
            return;
        }

        for(int i=idx;i<board.length;i++){
            if(board[i]==false){
                board[i]= true;
                function(board, q, qpsf+1,ans+"b"+i+"q"+qpsf,idx+1);
                board[i]=false;
            }
        }
    }
}
