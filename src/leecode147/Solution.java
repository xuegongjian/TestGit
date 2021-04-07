package leecode147;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int n = s.length();
        dp[n - 1] = (s.charAt(n - 1) == '0') ? 0 : 1;
        if(n==1){
            return  dp[0];
        }
        char  value= s.charAt(n - 2);
        if(value== '0'){
            dp[n-2]=0;
        } else  if(value=='1'){
            dp[n-2]=dp[n-1]+1;
        }else   if(value=='2'&& s.charAt(n - 1)<'7'){
            dp[n-2]=dp[n-1]+1;
        }else{
            dp[n-2]=1;
        }
        
        
        for (int i = n - 3; i >= 0; i--) {
            int d1 = Integer.valueOf(String.valueOf(s.charAt(i)));
            int d2 = Integer.valueOf(String.valueOf(s.charAt(i + 1)));
            if (d1 != 0) {
                dp[i] = dp[i + 1];
                int num = d1 * 10 + d2;
                if (num <= 26) {
                        dp[i] = dp[i + 1]+dp[i + 2];
                }
            }
        }
        return dp[0];
    }
    
    
    public	static	void	main(String[]	args){
    	System.out.println(new	Solution().numDecodings("1111"));
    }
}