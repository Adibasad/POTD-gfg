//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int n = arr.length;
        if (n < 3) return new ArrayList<>();  // No possible triplet in an array with less than 3 elements
        
        int[] left_smaller = new int[n];
        int[] right_greater = new int[n];

        // Initialize left_smaller and right_greater
        left_smaller[0] = -1;
        right_greater[n - 1] = -1;

        // Fill left_smaller array
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                left_smaller[i] = -1;
            } else {
                left_smaller[i] = min;
            }
        }

        // Fill right_greater array
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                right_greater[i] = -1;
            } else {
                right_greater[i] = max;
            }
        }
        // System.out.println(Arrays.toString(left_smaller));
        // System.out.println(Arrays.toString(right_greater));

        // Now find a triplet such that arr[left_smaller[i]] < arr[i] < arr[right_greater[i]]
        for (int j = 0; j < n; j++) {
            if (left_smaller[j] != -1 && right_greater[j] != -1) {
                List<Integer> result = new ArrayList<>();
                result.add(arr[left_smaller[j]]);
                result.add(arr[j]);
                result.add(arr[right_greater[j]]);
                return result;
            }
        }

        // If no such triplet is found
        return new ArrayList<>();
    }
}