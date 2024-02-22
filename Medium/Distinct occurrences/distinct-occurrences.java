//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String s, String t)
    {
        // Your code here
        int n=s.length();
	    int m=t.length();
	    
	    //recursion
	    //return count(0,0,n,m,s,t);
	    
	    int [][]dp = new int [n+1][m+1];
	    
	    //initialization
	    for(int i=0;i<n;i++) dp[i][0]=1;
	    
	    for(int i=1;i<=n;i++)
	    {
	       // dp[i][0]=0;
	        for(int j=1;j<=m;j++)
	        {
	            
	            if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=(dp[i-1][j-1] + dp[i-1][j])%1000000007;
	                
	            else dp[i][j]=dp[i-1][j]%1000000007;
	        }
	    }
	    
	    return dp[n][m];
    }
	
    }
    
    
    //-----------RECURSIVE-----------------
    // int count(int i,int j,int n,int m, String s, String t)
    // {
    //     if(j>=m) return 1;
        
    //     if(i>=n) return 0;
        
    //     int ans=0;
    //     //else move both pointers in both string to keep comparing
    //     if(s.charAt(i)==t.charAt(j))
    //     {
    //         //on match ,2 cases of charecter matching (one: continuously,sec:non-cont.)
    //         ans = (count(i+1,j+1,n,m,s,t) + count(i+1,j,n,m,s,t))%1000000007;
    //     }
        
    //     else 
    //     {
    //         ans = count(i+1,j,n,m,s,t)%1000000007;;
    //     }
        
    //     return ans;
    // }
