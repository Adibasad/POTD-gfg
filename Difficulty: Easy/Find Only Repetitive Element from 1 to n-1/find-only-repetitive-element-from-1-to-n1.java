//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            // Read the array from input line
            String inputLine = read.readLine().trim();
            String[] inputArr = inputLine.split("\\s+");
            int n = inputArr.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findDuplicate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        Arrays.sort(arr);
        int a=1;
        
        for(int i: arr) {
            // System.out.println(i);
            if(a!=i) return i; 
            a++;
        }
        
        return a;
        
        // ArrayList<Integer> a = new ArrayList<>();
        
        // for(int i=0;i<arr.length;i++)
        // {
        //     if(a.contains(arr[i])) return arr[i];
        //     else a.add(arr[i]);
        // }
        
        // return arr[arr.length-1];
    }
}