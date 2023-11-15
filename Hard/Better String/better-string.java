//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String s1, String s2) {
        // Code here
        int distSubSeq1 = distSubSeq(s1);
        int distSubSeq2 = distSubSeq(s2);
        
        return distSubSeq2>distSubSeq1? s2:s1;
    }
    
    static int distSubSeq(String s)
    {
        int mod = (int) 1e9 + 7;
        int n=s.length();
        long dp[] = new long[n+1];
        dp[0]=1;
        
        //map contains last occurence of a character in string
        Map<Character, Integer> lo= new HashMap<>();
        
        for(int i=1;i<=n;i++)
        {
            //double the entry for each new char
            dp[i]= (2* dp[i-1]) % mod;
            
            char ch=s.charAt(i-1);
            //if the element is repeated,then subtract the last number of occurences
            if(lo.containsKey(ch))
            {
                //index that this char last appeared
                int x= lo.get(ch);
                
                dp[i] = ( (dp[i]%mod) - (dp[x-1]%mod))%mod;
            }
            
            //updating laxt occurence
            lo.put(ch,i);
        }
        
        if(dp[n] < 0)
            dp[n] += mod;
            
        return (int)(dp[n] - 1 >= 0 ? dp[n] - 1 : 1e9 + 6);
        
    }
}