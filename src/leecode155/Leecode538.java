package leecode155;

import java.util.ArrayList;
import java.util.List;

public class Leecode538 {
	List<TreeNode> allNodes = new ArrayList<>();

	public TreeNode convertBST(TreeNode root) {
		if (null == root)
			return root;
		midSearch(root);
		for (int i = 0; i < allNodes.size(); i++) {
			TreeNode node = allNodes.get(i);
			int value = 0;
			for (int j = i; j < allNodes.size(); j++) {
				TreeNode tmpNode = allNodes.get(j);
				value = value + tmpNode.val;
			}
			node.val = value;
		}

		return root;
	}

	private void midSearch(TreeNode root) {
		if (root != null) {
			midSearch(root.left); // 递归遍历左子树
			allNodes.add(root); // 访问根节点
			midSearch(root.right); // 递归遍历右子树
		}
	}

	public static void main(String[] s) {
		// System.out.println(new Leecode538().convertBST(new char[] { 'A', 'A',
		// 'A', 'B', 'B', 'B' }, 2));

	}
}
