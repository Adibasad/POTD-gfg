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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int []ans=new int[2];
        
        Arrays.sort(nums);
        
        int k=0;
        int i=0;
        while(i<nums.length-1)
        {
            if(k==2) break;
            if(nums[i]==nums[i+1]) {
                i+=2;
                continue;
            }
            
            //curr ele is not equal to next ele
            ans[k++]=nums[i];
            i++;
            
        }
        
        if(i==nums.length-1) ans[k++]=nums[nums.length-1];
        
        return ans;
    }
}