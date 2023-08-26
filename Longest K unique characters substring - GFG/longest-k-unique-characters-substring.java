//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        //sliding window
        
        int max=-1;
        int start=0;
        
        Map<Character,Integer> map= new HashMap<>();
        
        for(int end=0;end<s.length();end++)
        {
            
            
            //keep moving the left ctr if diff chars are < k
            if(!map.containsKey(s.charAt(end)))
            {
                map.put(s.charAt(end),1);
            }
            else map.put(s.charAt(end), map.get(s.charAt(end))+1);
            
            //reduce window
            while(map.keySet().size()>k)
            {
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start))==0) map.remove(s.charAt(start));
                
                start++;
            }
            
            if(map.keySet().size()==k) max=Math.max(max, end-start+1);
            
        }
        
        
        return max;
    }
}