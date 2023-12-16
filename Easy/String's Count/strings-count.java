//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine().trim()); 

        while(t > 0){
        	long n = Integer.parseInt(br.readLine().trim()); 
            Solution ob = new Solution();
            System.out.println(ob.countStr(n)); 
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    static long countStr(long n)
	{
	    // code here
	    //all possible cases
	    //1: all a = nCn = 1
	    //2: 1 b   = nC1 = n
	    //3: 1 c   = nCn =n
	    //4: 1b 1c = nC1 * (n-1)C1 = n(n-1)
	    //5: 2c    = nC2/2 = [n(n-1)]/2
	    //6: 2c 1b = nC2/2 * (n-2)C1 = n(n-1)(n-2)/2
	    
	    return (1 + 2*n + (3*n*(n-1))/2 + (n*(n-1)*(n-2))/2);
	    
	}
} 