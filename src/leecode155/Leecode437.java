package leecode155;

public class Leecode437 {
	int cnt = 0;
	public int pathSum(TreeNode root, int sum) {
		
		if (root == null)
			return cnt;
		sum(0,root,sum);
		return cnt;

	}
	
	private void sum(int curValue,TreeNode root, int sum){
		if(root == null) return;
		if(curValue+root.val == sum){
			cnt++;
		}
		sum(curValue+root.val,root.left,sum);

		sum(0,root.left,sum);
		

		sum(curValue+root.val,root.right,sum);
		

		sum(0,root.left,sum);
		
		
	}
	
	

	public static void main(String[] s) {
//		System.out.println(new Leecode437().findDuplicate(new int[] { 1, 2, 3, 4, 3 }));

	}
}
