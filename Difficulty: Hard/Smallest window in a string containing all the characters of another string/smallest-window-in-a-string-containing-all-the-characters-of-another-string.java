//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string t.
    public static String smallestWindow(String s, String t)
    {
        // Your code here
        int [] arr = new int[128];
        for (char c : t.toCharArray()) {
            arr[c]++;
         }
    int start = 0, end = 0, minStart = 0;
    int minLen = Integer.MAX_VALUE, counter = t.length();
    while (end < s.length()) {
      char c1 = s.charAt(end);
      if (arr[c1] > 0) {
          counter--;
      }
      arr[c1]--;
      end++;
      while (counter == 0) {
        if (minLen > end - start) {
          minLen = end - start;
          minStart = start;
        }
        char c2 = s.charAt(start);
        arr[c2]++;
        if (arr[c2] > 0) {
            counter++;
        }
        start++;
      }
    }
    return minLen==Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart+minLen);
}
}