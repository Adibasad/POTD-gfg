//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String str){
        // code here
        int n=str.length();
        boolean seen[]=new boolean[n];
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<n) {
            if(str.charAt(i)=='(') {
                st.push(i);
            }else {
                if(!st.isEmpty() &&   str.charAt(st.peek())=='(' ) {
                    int tem=st.pop();
                    seen[tem]=true;
                    seen[i]=true;
                }
            }
            i++;
        }

        int cnt=0;
        int ans=0;
        for(int j=0;j<n;j++) {
            if(seen[j]==true) cnt++;
            else cnt=0;
            ans=Math.max(ans, cnt);
        }
        return ans;
    }
}