package backtrackingConcept;

public class coinChangeProblem {
    public static void main(String[] args) {
        int[] coin= {2,3,5,7};
        int amount=10;
        function(coin, amount, "");
    }
    public static void function(int[] coin, int amount, String ans){
        if(amount==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<coin.length;i++){
            if(amount>=coin[i]){
                // amount-=coin[i];  
                // bactracking from above approch ↥ bacause recursion an't undo changes
                function(coin, amount-coin[i], ans+coin[i]);
                //no change in heap => no backtracking beacuse recursion can undo by itself
            }
        }
    }
}
