//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        // code here
        long mod= (long) 1e9+7;
        long v1=1, v2=1,v3;
        for(int i=1;i<n;i++){
            v3=v1;
            v1= (v1+v2)% mod;
            v2= v3% mod;
        }
        return (v1+v2)%mod;
    }
}