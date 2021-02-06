package leecode155;

public class Leecode45 {
	public int jump(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int N = nums.length;
		int[] min = new int[N];
		min[0] = 0;
		int currentMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				if(currentMax >= i+j){
					continue;
				}
				currentMax = Math.max(currentMax, i+j);
				if (i + j >= N) {
					break;
				}
				if (min[i + j] == 0) {
					min[i + j] = min[i] + 1;
				} else {
					min[i + j] = Math.min(min[i + j], min[i] + 1);
				}
			}
		}

		return min[N - 1];
	}

	public static void main(String[] s) {
		int[] nums = new int[] {5,9,3,2,1,0,2,3,3,1,0,0};
		System.out.println(new Leecode45().jump(nums));

	}
}
