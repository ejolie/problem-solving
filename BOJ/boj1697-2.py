'''
boj1697. 숨바꼭질
'''
from sys import stdin
def bfs(A):
	q = [A]
	visited[A] = 1
	while q != []:
		x = q.pop(0)
		if x == B:
			return visited[x] - 1
		if 0 <= x-1 < N and not visited[x-1]:
			visited[x-1] = visited[x] + 1
			q.append(x-1)
		if 0 <= x+1 < N and not visited[x+1]:
			visited[x+1] = visited[x] + 1
			q.append(x+1)
		if 0 <= 2*x < N and not visited[2*x]:
			visited[2*x] = visited[x] + 1
			q.append(2*x)

A, B = map(int, stdin.readline().rstrip().split())
N = 100001g
visited = [0] * N
print('%d' % bfs(A))