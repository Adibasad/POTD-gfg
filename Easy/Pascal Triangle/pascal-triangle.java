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

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n)
    {
        // code here
        if(n==1)
        {
            ArrayList<Long> row=new ArrayList<>();
            row.add(1L);
            return row;
        }
        
        ArrayList<Long> prevRow= nthRowOfPascalTriangle(n - 1);
        ArrayList<Long> currentRow = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            if (i == 0 || i == (n - 1)) currentRow.add(1L);
            else 
            {
                long digit = (prevRow.get(i) + prevRow.get(i - 1)) % (1000000007);
                currentRow.add(digit);
            }
        }
        return currentRow;
    }
}