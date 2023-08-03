import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
   }
}
public class duplicateSubtree {
    static HashMap<String, TreeNode> map= new HashMap<>();
    static HashSet<TreeNode> set= new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        duplicate(root);
        return new ArrayList<>(set);
    }
    public static String duplicate(TreeNode root){
        if(root==null){
            return "x";
        }
        String left= duplicate(root.left);
        String right= duplicate(root.right);
        String s= root.val+left+right;
        if(map.containsKey(s)){
            set.add(map.get(s));
        }else{
            map.put(s,root);
        }
        return s;
    }
}
