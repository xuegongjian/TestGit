package leecode155;

import java.util.Arrays;

public class Leecode300 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0]=1;

		for(int i= 1; i< nums.length; i++){
            dp[i]=1;
			for(int j = 0;j<i;j++){
				if(nums[j] < nums[i]){ 
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
        int max = 1;
        for(int i= 1; i< nums.length; i++){
            max = Math.max(dp[i],max);
        }

		return max;
	}


	public static void main(String[] s) {
		new Leecode300().lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6});
	}
}
