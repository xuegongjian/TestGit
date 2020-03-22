package leecode155;

public class Leecode287 {
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int value = 0;
		for(int i =1; i <= n-1; i++){
			value = value ^ i;
		}
		
		for(int i:nums){
			value = value ^ i;
		}
		
		
		return value;
	}

	public static void main(String[] s) {
		System.out.println(new Leecode287().findDuplicate(new int[]{1,2,3,4,3}));
		
		
		
		
	}
}
