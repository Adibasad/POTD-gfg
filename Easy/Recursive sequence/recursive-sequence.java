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
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        // code here
        
        if(n==1) return 1;
        
        long mod = 1000000007;
        long ans=1;
        long prod=1;
        long c=2;
        
        
        for(int i=2;i<=n;i++)
        {
            prod=1;
            for(int j=1;j<=i;j++)
            {
                prod= (prod*c)%mod;
                c++;
            }
            
            
            ans = (ans+prod)%mod;
        }
        
        return ans%mod;
        
        
    }
}