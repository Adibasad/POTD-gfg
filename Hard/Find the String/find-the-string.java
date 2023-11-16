//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt(), K = sc.nextInt();
            Solution ob = new Solution();
            String ans = ob.findString(N, K);
            boolean ok = true;
            for(int i = 0; i < ans.length(); i++){
                char c = ans.charAt(i);
                if(c < '0' || c > K - 1 + '0')
                    ok = false;
            }
            if(!ok){
                out.println("-1");
                continue;
            }
            HashSet<String> st = new HashSet<String>();
            for(int i = 0; i + N - 1 < ans.length(); i++){
                st.add(ans.substring(i, i+N));
            }
            int tot = 1;
            for(int i=1;i<=N;i++)
                tot *= K;

            if(st.size() == tot){
                out.println(ans.length());
            }
            else{
                out.println("-1");
            }
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String findString(int n, int k){
        
    Set<String> visited = new HashSet<>(); // Set to keep track of visited strings
        String startingNode = new String(new char[n - 1]).replace('\0', '0'); // Starting node with (n-1) '0' characters
        List<Integer> path = new ArrayList<>(); // List to store the DFS path
        dfs(k, startingNode, visited, path); // Perform DFS to generate strings

        StringBuilder result = new StringBuilder();
        int totalPaths = (int) Math.pow(k, n);

        // Build the final string by appending characters from the DFS path
        for (int i = 0; i < totalPaths; i++) {
            result.append(path.get(i));
        }

        result.append(startingNode); // Append the starting node
        return result.toString(); // Convert StringBuilder to String and return
    }

    // Recursive DFS function
    private static void dfs(int k, String current, Set<String> visited, List<Integer> path) {
        for (int i = 0; i < k; i++) {
            String next = current + (char) ('0' + i); // Append characters from 0 to k-1
            if (!visited.contains(next)) {
                visited.add(next); // Mark the string as visited
                dfs(k, next.substring(1), visited, path); // Recursively call DFS with the updated string
                path.add(i); // Add the current character to the path
            }
        }
    }
}