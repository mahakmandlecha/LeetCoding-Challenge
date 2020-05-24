
class Solution {
    TreeNode p1=null, p2=null;
        int d1=-1,d2=-1;
    public boolean isCousins(TreeNode root, int x, int y) {
        find(root, x, y, 0, null);
        return d1 == d2 && p1 != p2;
    }
    public void find(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            p1 = parent;
            d1 = depth;
        }else if(root.val == y){
            p2 = parent;
            d2 = depth;
        } else {     
        find(root.left, x, y, depth + 1, root);
        find(root.right, x, y, depth + 1, root); }
    }
}
