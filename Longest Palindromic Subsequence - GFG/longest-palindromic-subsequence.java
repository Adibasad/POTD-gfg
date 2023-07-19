//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String A)
    {
        //code here
        //using longest common subsequence of the string and it's reverse--->logest palindrome subseq
        //DP
        
        int n=A.length();
        
        //reverse
        StringBuilder sb=new StringBuilder(A);
        sb.reverse();
        String B=sb.toString();
        
        int [][] dp=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(A.charAt(i-1)==B.charAt(j-1))  dp[i][j]=1+dp[i-1][j-1];  //if the charecters match
                
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}