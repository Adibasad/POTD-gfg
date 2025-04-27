//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        int sign = 1;

        // Handle negative signs
        if (s1.charAt(0) == '-') {
            sign *= -1;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            sign *= -1;
            s2 = s2.substring(1);
        }

        // Remove leading zeros
        while (s1.length() > 1 && s1.charAt(0) == '0') {
            s1 = s1.substring(1);
        }
        while (s2.length() > 1 && s2.charAt(0) == '0') {
            s2 = s2.substring(1);
        }

        // If any string becomes "0" after trimming
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }

        int n = s1.length(), m = s2.length();
        int[] res = new int[n + m];

        // Multiply each digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                res[i + j + 1] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        // Handle carry over
        for (int i = n + m - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        // Skip leading zero if present
        int idx = (res[0] == 0) ? 1 : 0;

        // Build result string
        StringBuilder ans = new StringBuilder();
        for (; idx < n + m; idx++) {
            ans.append(res[idx]);
        }

        if (sign == -1) {
            ans.insert(0, '-');
        }

        return ans.toString();
    }
}