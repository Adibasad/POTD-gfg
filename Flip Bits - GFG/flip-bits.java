//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int zero=0,one=0,max=0;
        for(int i:a)
        {
            if(i==0) zero++;
            
            //potentially the zero can be converted(when encounter one after zero,
            // only convert if the ones are more than prev zeros)
            else {
                zero--;
                one++;
            }
            
            max=Math.max(zero,max);
            
            if(zero<0) zero=0;
            
        }
        
        return one+max;
    }
}
