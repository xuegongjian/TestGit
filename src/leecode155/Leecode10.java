package leecode155;

public class Leecode10 {
	public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) return true;
		int N = p.length();
		int j = 0;
		char lastChar = '0';
		for(int i = 0; i <s.length();i++){
			char v = s.charAt(i);
			if(j>=N) return false;
			char v2 =  p.charAt(j);
			if(v2== v || v2 == '.'){
				lastChar = v2;
				j=j+1;
				continue;
			}
			
			if(v2 != v  && v2 != '*'){
				j=j+1;
				if(j< N && p.charAt(j) == '*'){
					j=j+1;
					i=i-1;
					continue;
				} else {
					return false;
				}
			} if(v2 == '*'){
				if(lastChar != '.') {
					if(v != lastChar){
						return false;
					}
					
					int count = 0;
					int count2 = 0;
					for(int k = j+1; k<N; k++){
						if(p.charAt(k) == lastChar){
							count++;
						}
					}
					for(int k = i; k<s.length(); k++){
						if(s.charAt(k) == lastChar){
							count2++;
						}
					}
					
					if(count>count2){
						return false;
					} else {
						j = j + count+1;
						i = i + count2-1;
					}
				} else {
					
					
					
				}
			}
		}
		return p.length() == (j);
    }
	public static void main(String[] s) {
		test();

	}
	
	public static void test(){
		try{
			throw new RuntimeException("111");
		}finally{
			
		}
		
	}
}
