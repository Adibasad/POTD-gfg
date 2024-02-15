//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isPossible(int[][] paths)
    {
        // Code here
        //Checking for eulerian cycle:if all rows are connected with even number of nodes
        //Eucerian cycle is a cycle in which start with a node and return to it while covering all nodes
        
        int r=paths.length;
        int c=paths[0].length;
        
        for(int i=0;i<r;i++)
        {
            int rowSum=0;
            
            for(int j=0;j<c;j++)
            {
                if(paths[i][j]==1) rowSum++;
            }
            
            if(rowSum%2!=0) return 0;
        }
        
        return 1;
        
        
        
        
    }
}