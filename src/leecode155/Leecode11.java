package leecode155;

public class Leecode11 {
	public int maxArea(int[] height) {
		int start = 0; 
		int end = height.length -1 ;
		int maxArea = 0;
		while(start< end){
			maxArea =Math.max(Math.min(height[start],height[end]) * (end - start),maxArea);
			if(height[start] <= height[end]) {
				int tmp = height[start] ;
				while(tmp >= height[start] && start < end){
					start++;
				}
				continue;
			} else {
				int tmp = height[end] ;
				while(tmp >= height[end] && start < end){
					end--;
				}
				continue;
			}
		}
		return maxArea;
    }

	public static void main(String[] s) {
//		System.out.println(new Leecode11().findTargetSumWays(new int[]{1,1,1,1,1},5));

	}
}
