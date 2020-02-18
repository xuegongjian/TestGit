package leecode155;

public class Leecode152 {
	public int maxProduct(int[] nums) {
		if(nums == null) return 0;
		int maxValue = nums[0];
		int currentValue = 1;
		for(int value : nums){
			currentValue = currentValue * value;
			maxValue = Math.max(currentValue, maxValue);
			if(currentValue == 0){
				currentValue = 1;
			}
		}	
		currentValue = 1;
		for(int i = nums.length-1; i> 0;i--){
			currentValue = currentValue * nums[i];
			maxValue = Math.max(currentValue, maxValue);
			if(currentValue == 0){
				currentValue = 1;
			}
		}	
		
		return maxValue;
	}
	
	public static void main(String[] s) {
		System.out.println(new Leecode279().numSquares(4093));
	}
}
