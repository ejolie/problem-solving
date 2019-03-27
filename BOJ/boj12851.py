'''
boj12851. 숨바꼭질 2
- 최소로 도착 가능한 시간
- 최소로 도착하는 경우의 수

'''
from sys import stdin
def bfs(v):
	check[v] = [0, 1] # time, cnt
	q = [v]
	while q != []:
		x = q.pop(0)
		if x == B:


		if 0 <= x-1 < N and not check[x-1][0]:
			q.append(x-1)


		if 0 <= x+1 < N and not check[x+1][0]:
			q.append(x+1)
		if 0 <= 2*x < N and not check[2*x][0]:
			q.append(2*x)

A, B = map(int, stdin.readline().rstrip().split())
N = 100001
check = [[N, 0] for _ in range(N)]
bfs(A)