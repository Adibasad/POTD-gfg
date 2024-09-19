//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        // code here
         String[] arr = S.split("\\.");
        StringBuilder res = new StringBuilder();
        for(int i =arr.length-1; i >=0 ; i--){
            res.append(arr[i]);
            if(i!=0)
                res.append('.');
        }
        return res.toString();
    }
}