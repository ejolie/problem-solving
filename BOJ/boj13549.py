'''
boj13549. 숨바꼭질 3
'''
from sys import stdin
def bfs(v):
	visited[A] = 1
	q = [(A, 0)]
	mincnt = N
	while q != []:
		x, cnt = q.pop(0)
		if cnt >= mincnt:
			continue
		if x == B:
			visited[x] = 0
			if cnt < mincnt:
				mincnt = cnt
		else:
			if 0 <= 2*x < N and not visited[2*x]:
				visited[2*x] = 1
				q.append((2*x, cnt))
			if 0 <= x-1 < N and not visited[x-1]:
				visited[x-1] = 1
				q.append((x-1, cnt+1))
			if 0 <= x+1 < N and not visited[x+1]:
				visited[x+1] = 1
				q.append((x+1, cnt+1))
	print(mincnt)

A, B = map(int, stdin.readline().rstrip().split())
N = 100001
visited = [0] * N
bfs(A)