

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class LcaDeepest {

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        if(root == null){
            return null;
        }
        else if(getHeight(root.left) == getHeight(root.right)){
            return root;
        }
        else if(getHeight(root.left) > getHeight(root.right)){
            return lcaDeepestLeaves(root.left);
        }
        else{
            return lcaDeepestLeaves(root.right);
        }

    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

}
