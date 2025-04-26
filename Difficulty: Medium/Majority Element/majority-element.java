//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {

    static int majorityElement(int arr[]) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort map entries by their values (counts) in decreasing order
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        // Print to see the sorted order
        // for (Map.Entry<Integer, Integer> entry : entryList) {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }

        // Majority Element condition
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
