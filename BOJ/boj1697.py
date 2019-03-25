'''
boj1697. 숨바꼭질
'''
from sys import stdin
def bfs(A):
	q = [(A, 0)]
	while q != []:
		x, cnt = q.pop(0)
		if x == B:
			return cnt
		if 0 <= x-1 < N-1 and not visited[x-1]:
			visited[x-1] = 1
			q.append((x-1, cnt+1))
		if 0 <= x+1 < N-1 and not visited[x+1]:
			visited[x+1] = 1
			q.append((x+1, cnt+1))
		if 0 <= 2*x < N-1 and not visited[2*x]:
			visited[2*x] = 1
			q.append((2*x, cnt+1))

A, B = map(int, stdin.readline().rstrip().split())
N = 1000001
mat = [0] * N
visited = [0] * N
print('%d' % bfs(A))