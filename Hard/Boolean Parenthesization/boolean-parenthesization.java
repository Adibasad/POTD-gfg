//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        // code here
        
          int mod = 1003;
        int[][][] dp = new int[N][N][2];

        for (int gap = 0; gap < N; gap += 2) {
            for (int i = 0, j = gap; j < N; i += 2, j += 2) {
                for (int isTrue = 0; isTrue < 2; isTrue++) {
                    if (i == j) {
                        dp[i][j][isTrue] = (S.charAt(i) == 'T' && isTrue == 1) || (S.charAt(i) == 'F' && isTrue == 0) ? 1 : 0;
                    } else {
                        for (int k = i + 1; k < j; k += 2) {
                            int lt = dp[i][k - 1][1];
                            int lf = dp[i][k - 1][0];
                            int rt = dp[k + 1][j][1];
                            int rf = dp[k + 1][j][0];

                            if (S.charAt(k) == '^') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rf + rt * lf : lt * rt + lf * rf);
                            } else if (S.charAt(k) == '&') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rt : lt * rf + rt * lf + lf * rf);
                            } else if (S.charAt(k) == '|') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rf + rt * lf + lt * rt : lf * rf);
                            }

                            dp[i][j][isTrue] %= mod;
                        }
                    }
                }
            }
        }

        return dp[0][N - 1][1];
    }
}