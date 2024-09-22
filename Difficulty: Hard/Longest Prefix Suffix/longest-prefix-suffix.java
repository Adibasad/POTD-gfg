//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
         int len = 0;
        int n = str.length();
        int [] lps = new int[n];
        int i = 1;
        
        while(i < n)
        {
            if(str.charAt(i) == str.charAt(len))
                lps[i++] = ++len;
            else
            {
                if(len > 0)
                    len = lps[len-1];
                else
                    i++;
            }
        }

        return lps[n-1];
    }
}