'''
boj13549. 숨바꼭질 3
'''
def bfs(v):
	visited[A] = True
	q = [(A, 0)]
	while q != []:
		x, cnt = q.pop(0)
		if x == B:
			return cnt
		if 0 <= 2*x < N and not visited[2*x]:
			visited[2*x] = True
			q.append((2*x, cnt))
		if 0 <= x-1 < N and not visited[x-1]:
			visited[x-1] = True
			q.append((x-1, cnt+1))
		if 0 <= x+1 < N and not visited[x+1]:
			visited[x+1] = True
			q.append((x+1, cnt+1))

A, B = map(int, input().split())
N = 100001
visited = [False] * N
print(bfs(A))