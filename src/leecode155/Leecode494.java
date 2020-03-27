package leecode155;

public class Leecode494 {
	int count = 0;
	public int findTargetSumWays(int[] nums, int S) {
		if(nums == null) return count;
		dfs(0,nums,S);
		return count ;
	}
	
	private void dfs(int step,int[] nums, int currentValue){
		if(step == nums.length){
			if(currentValue == 0){
				count = count + 1;
			}
			return;
		}
		dfs(step+1,nums,currentValue-nums[step]);

		dfs(step+1,nums,currentValue+nums[step]);
	}

	public static void main(String[] s) {
		System.out.println(new Leecode494().findTargetSumWays(new int[]{1,1,1,1,1},5));

	}
}
