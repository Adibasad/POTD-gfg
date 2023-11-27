class Solution:
    def __init__(self):
        self.p = []

    def combine(self, a, b):
        x = self.find(a)
        y = self.find(b)
        if x != y:
            self.p[y] = x
            return False
        return True

    def find(self, n):
        if self.p[n] != n:
            self.p[n] = self.find(self.p[n])
        return self.p[n]

    def detectCycle(self, V, adj):
        self.p = list(range(V))
        for i in range(V):
            for j in adj[i]:
                if i < j:
                    continue
                if self.find(i) == self.find(j):
                    return 1
                self.combine(i, j)
        return 0



#{ 
 # Driver Code Starts

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		V, E = map(int, input().split())
		adj = [[] for i in range(V)]
		for _ in range(E):
			u, v = map(int, input().split())
			adj[u].append(v)
			adj[v].append(u)
		obj = Solution()
		ans = obj.detectCycle(V, adj)
		print(ans)
# } Driver Code Ends