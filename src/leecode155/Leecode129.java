package leecode155;

public class Leecode129 {
	int total = 0;
	public int sumNumbers(TreeNode root) {
		if(null == root){
			return 0;
		}
		pre(root, "0");
		return total;
	
	}
	public void pre(TreeNode root,String value){
		if(root.left == null && root.right == null){
			total = total + Integer.valueOf(value + root.val);
			return;
		}
		String newValue = value + root.val;
		if(null != root.left) {
			pre(root.left,newValue);
		}
		if(null != root.right) {
			pre(root.right,newValue);
		}
		
	}

	public static void main(String[] s) {
//		System.out.println(new Leecode129().sumNumbers(new int[] { 1, 1, 1, 1, 1 }, 5));

	}
}
