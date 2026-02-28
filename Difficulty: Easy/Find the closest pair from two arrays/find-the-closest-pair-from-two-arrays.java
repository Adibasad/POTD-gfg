class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int n= arr1.length;
        int m=arr2.length;
        
        //to tranverse through both arrays
        int i=0;
        int j=m-1;
        int sum=0;
        int min = Integer.MAX_VALUE;
        
        int l=0,r=0; //to store idx of required elements
        
        ArrayList<Integer> res = new ArrayList<>();
        
        //tranversing one array from left-to-right and the other right to left
        //two pointer + greedy approach 
        while(i<n && j>=0)
        {
            sum = arr1[i]+arr2[j];
            int diff = Math.abs(x-sum);
            
            if(diff<min)
            {
                min=diff;
                l=i;
                r=j;
            }
            if(sum==x)
            {
               res.add(arr1[l]);
               res.add(arr2[r]);
               return res;
            }
            else if(sum<x) i++;
            else j--;
        }
        res.add(arr1[l]);
        res.add(arr2[r]);
        return res;
        
    }
}