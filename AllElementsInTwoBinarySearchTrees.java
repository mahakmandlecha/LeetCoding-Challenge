class AllElementsInTwoBinarySearchTrees {
    public List<Integer> inOrder(TreeNode root, List<Integer> list){
        if(root == null) return list;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return list;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = inOrder(root1, new ArrayList<>());
        ans.addAll(inOrder(root2, new ArrayList<>()));
        Collections.sort(ans);
        return ans;
    }
}