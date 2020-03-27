package leecode155;

public class Leecode621 {
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null)
			return 0;
		if(tasks.length == 0) return 0;
		int [] cnt = new int[26];
		int max = 0;
		for(char c : tasks){
			cnt[c-'A'] = cnt[c-'A'] + 1;
			max =	Math.max(max, cnt[c-'A']);
		}
		if(max==1){
			return tasks.length;
		}
		int count = -1;
		for(int value : cnt){
			if(value == max) count++;
		}
		
		max = (max-1) * (n+1) + count;
		
		return max;
	}

	public static void main(String[] s) {
		System.out.println(new Leecode621().leastInterval(new char[] {'A','A','A','B','B','B'},2));

	}
}
