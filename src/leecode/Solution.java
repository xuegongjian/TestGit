package leecode;

class Solution {
	int[]cache;
	public int tribonacci(int n) {
        if(n==0)return  0;
        if(n==1)return  1;
        if(n==2)return  1;
        cache=new    int[n+1];
        cache[0]=0;
        cache[1]=1;
        cache[2]=1;
        for(int i=3;i<=n;i++){
            cache[i]=cache[i-1]+cache[i-2]+cache[i-3];
            
        }
        return cache[n];     
    }
    
    public	static	void	main(String[]	args){
    	System.out.println(new	Solution().tribonacci(25));
    }
}