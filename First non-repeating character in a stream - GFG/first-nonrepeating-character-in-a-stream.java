//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
         int[] a = new int[26];
         
         int n=A.length();
        //  String str = "";
         StringBuilder str = new StringBuilder();
         Queue<Character> que = new LinkedList<>();  //temp storage
        
        for(int i=0;i<n;i++){
            char ch = A.charAt(i);
            int val = ch - 'a';
            a[val]++;
    
            if(a[val] <= 1)
                que.add(ch);
                
            //if the words repeat,empty the queue and add #    
            while(que.isEmpty()==false && a[que.peek()-'a']>1 )
            {
                que.poll();
            }
                
            if(que.isEmpty())
                // str += '#';
                str.append('#');
            else    
                // str += que.peek();
                str.append(que.peek());
        }
        return str.toString();
        
    }
}