//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        //sort them then inc the smaller and dec the larger elements to make the diffrence min
        
        Arrays.sort(arr);
        int n=arr.length;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int ans=arr[n-1]-arr[0];
        
        // System.out.println(Arrays.toString(arr));
        for(int i=1;i<n;i++)
        {
            if(arr[i]-k<0) continue;
            min = Math.min(arr[0]+k, arr[i]-k);
            max = Math.max(arr[n-1]-k, arr[i-1]+k);
            ans = Math.min(ans, max-min);
        }
        
        
        return ans;
    }
}
