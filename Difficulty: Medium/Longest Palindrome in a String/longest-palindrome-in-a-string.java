//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    
    static String longestPalindrome(String s) {
        // code here
    String max = s.substring(0,1);
    int n= s.length();
    
    for(int i=0; i<n-1;i++)
    {
        //for even numbered palindrome
        String sub1 = expandAround(s,i,i+1);
        if(sub1.length()>max.length()) max = sub1; 
        //for oddd 
        String sub2 = expandAround(s,i,i);
        if(sub2.length()>max.length()) max = sub2; 
        
     
    }
    return max;
    }
    
    static String expandAround(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    
    
}