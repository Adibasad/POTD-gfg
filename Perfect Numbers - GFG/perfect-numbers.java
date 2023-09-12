//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        // code here
        if(N<=1) return 0;
        long count=1;
        long factor1,factor2;
        int n=(int)Math.sqrt(N);
        for(long i=2;i<=n;i++){
            if(N%i==0){
                factor1=i;
                factor2=N/i;
                count+=factor1+factor2;
            }
        }
        if(count==N) return 1;
        return 0;
    }
}