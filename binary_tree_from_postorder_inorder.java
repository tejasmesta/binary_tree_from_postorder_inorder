class Solution {
        
    HashMap<Integer,Integer> map =new HashMap<>(); 
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        
        return build(postorder, 0, n-1, inorder, 0, n-1);
              
    }
    
    TreeNode build(int post[],int ps,int pe,int in[],int is,int ie)
    {
        if(is>ie)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(post[pe]);
        
        int index = map.get(post[pe]);
        
        int t = index-is;
        
        root.left = build(post,ps,ps+t-1,in,is,index-1);
        root.right = build(post,ps+t,pe-1,in,index+1,ie);
        
        return root;
    }
}
