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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String s) {
        // code here
        int start=0;
        int end=s.length()-1;
        boolean flag=false;
        
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end)) {
                flag=true;
                break;
            }
            start++;
            end--;
            
        }
        
        if(flag) return 0;
        
        return 1;
    }
};