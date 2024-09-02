//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> a1, List<Integer> a2) {
        // code here
        
        int sum1=0,sum2=0;
        int ans=0;
        int i=0,j=0;
        
        while(i<a1.size() && j<a2.size())
        {
            if(a1.get(i)<a2.get(j))
            {   
                sum1+=a1.get(i);
                i++;
                
            }
            
            else if(a1.get(i)>a2.get(j))
            {
                sum2+=a2.get(j);
                j++;
            }
            
            else {
                
                ans+=Math.max(sum1,sum2)+a1.get(i);
                i++;
                j++;
                sum1=0;
                sum2=0;
                
            }
        }
        
        while(i<a1.size())
        {
            sum1+=a1.get(i++);
        }
        
        while(j<a2.size())
        {
            sum2+=a2.get(j++);
        }
        
        
        return Math.max(sum1, sum2)+ans ;
    }
}