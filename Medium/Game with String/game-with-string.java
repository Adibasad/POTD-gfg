//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        
        HashMap<Character, Integer> map= new HashMap<>();
        int sum=0;
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        ArrayList<Integer> arr= new ArrayList<>();
        for(int count: map.values()) arr.add(count);
        
        //Reduce the largest value each time until k runs out
        while(k>0)
        {
            //in reverse order
            Collections.sort(arr, Collections.reverseOrder());
            int temp=arr.get(0);
            arr.remove(0);
            arr.add(temp-1);
            k--;
            
        }
        
        for(int i: arr) sum+= i*i;
        
        return sum;
    }
}