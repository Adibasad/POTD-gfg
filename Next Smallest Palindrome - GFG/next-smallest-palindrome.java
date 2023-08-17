//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Vector<Integer> ans=new Vector<>();
    
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        
        
        // case 1:are all nines and is a palindrome
        //case 2:not a palindrome 
        //case 3:palindrome but not all 9
        
        if(n==1){
            if(num[0]==9){
                ans.add(1);
                ans.add(1);
            }
            else ans.add(num[0]+1);
            return ans;
        }
        
        if(AreAll9(num,n)){
            ans.add(1);
            for(int i=1;i<n;i++) ans.add(0);
            ans.add(1);
            return ans;
        }
        
        else{
            generateNext(num,n);
            return ans;
        }
        
    }
    
    boolean AreAll9(int a[],int n)
    {
        for(int i:a) if(i!=9) return false;
        return true;
    }
    
    void generateNext(int []num,int n)
    {
        boolean leftSmall=false;
        boolean leftEqual=false;
        int mid=n/2;
        int i=mid-1;
        int j = (n%2==0) ? mid: mid+1;
        //until the same ele 
        while(i>=0 && num[i]==num[j])
        {
            i--;
            j++;
        }
        if(i==-1) leftEqual=true;
        if(i>=0 && num[i]<num[j]) leftSmall=true;
        
        //convert the next half on right side
        while(i>=0) num[j++]=num[i--];
        
        //now adjust the mid and number accordingly if left was smaller
        if(leftSmall || leftEqual)
        {
            int carry=1;
            if(n%2==1){
                num[mid]+=1;
                carry=num[mid]/10;
                num[mid]%=10;
                
            }
            
            
           i=mid-1;
           j = (n%2==0) ? mid: mid+1;
           while(i>=0)
           {
               num[i]+=carry;
               carry=num[i]/10;
               num[i]%=10;
               num[j]=num[i];
               i--;
               j++;
           }
            
            
        }
        
        
        for(int x=0;x<n;x++) ans.add(num[x]);
        
        
    }
    
    
}