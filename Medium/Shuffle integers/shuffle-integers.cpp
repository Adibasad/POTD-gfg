//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	
	public:
	void shuffleArray(int arr[],int n)
	{
	    // Your code goes here
	    
	 int maxi=1e5;
	    int i=0;
	    int j=n/2;
	    
	    while(j<n)
	    {
	        arr[i]=(arr[j]*maxi)+arr[i];
	        i++;
	        j++;
	    }
	    
	    i=(n/2)-1;
	    j=n-1;
	    
	    while(i>=0)
	    {
	        arr[j]=arr[i]/maxi;
	        arr[j-1]=arr[i]%maxi;
	        j-=2;
	        i--;
	    }
	    
	}
};

//{ Driver Code Starts.


int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
	    cin>>n;
	    int a[n] ;
	    for(int i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }


       

        Solution ob;
        ob.shuffleArray(a, n);

		for (int i = 0; i < n; i++) 
			cout << a[i] << " ";
    
	
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends