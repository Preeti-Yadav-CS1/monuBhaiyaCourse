package backtrackingConcept;
import java.util.*;
public class ratChase {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        try{
            int n= scanner.nextInt();
            int m= scanner.nextInt();
            char[][] maze= new char[n][m];
            for(int i=0; i<maze.length;i++){
                String str= scanner.next();
                for(int j=0;j<str.length();i++){
                    maze[i][j]= str.charAt(j);
                }
            }

            int [][] ans= new int[n][m];

            hasPath(maze, 0, 0, ans);


        }finally{
            scanner.close();
        }
    }
    public static void hasPath(char[][] maze, int cc, int cr, int [][]ans){

        if(cr==maze.length-1 && cc==maze[0].length-1 && maze[cr][cc]!='X'){
            ans[cr][cc]=1;
            Display(ans);
        }

        if(cr<0||cc<0|| cr>=maze.length|| cc>= maze[0].length|| maze[cr][cc]=='X'){
            return;
        }

        maze[cr][cc]= 'X';
        ans[cr][cc]= 1;

        hasPath(maze, cc, cr-1,ans); //up
        hasPath(maze, cc, cr+1,ans); //down
        hasPath(maze, cc-1, cr,ans); //left
        hasPath(maze, cc+1, cr,ans); // right

        maze[cr][cc]= 'O';
        ans[cr][cc]= 0;
    }

    public static void Display(int[][] ans){
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++)
                System.out.println(ans[i][j]);
        }
    }
}
