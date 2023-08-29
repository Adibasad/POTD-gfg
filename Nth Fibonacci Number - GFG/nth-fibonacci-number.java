//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        if(n==0) return 0;
        
        int mod=1000000007;
        
        long prev1=1;
        long prev2=1;
        long curr=1;
        for(int i=1;i<n-1;i++)
        {
            curr=prev1%mod+prev2%mod;
            // System.out.println(prev1+" "+prev2+" "+curr);
            prev1=prev2;
            prev2=curr;
            
        }
        
        return (int)curr%mod;
    
    }
}