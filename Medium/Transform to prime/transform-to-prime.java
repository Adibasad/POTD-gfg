//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minNumber(int arr[], int N)
    {
        int temp=0;
        for(int x:arr) temp+=x;
        if(temp==1) return 1;
        int sum=temp;
        
        while(!isPrime(temp)) temp++;
        
        return (temp-sum);

    }
    
    public boolean isPrime(int num)
    {
        for(int i=2;i<=num/2;i++)
        {
            if(num%i==0) return false;
        }
        
        return true;
    }
}
