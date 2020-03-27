package leecode155;

import java.util.HashMap;
import java.util.Map;

public class Leecode236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		
		while(true){
			boolean left = contain(root.left,p) && contain(root.left,q);
			if(left){
				root = root.left;
				continue;
			}
			boolean rigth = contain(root.right,p) && contain(root.right,q);
			if(rigth){
				root = root.right;
				continue;
			}
			return root;
			
		}
	}

	public boolean contain(TreeNode root, TreeNode p){
		if(null == root) return false;
		if(root==p){
			return true;
		}
		return contain(root.right,p) ||  contain(root.left,p);
	}
	
	
	public static void main(String[] s) {
		// System.out.println(new Leecode211().maximalSquare(new
		// int[]{1,2,3,4,3}));

	}
}
