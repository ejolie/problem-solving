'''
boj12851. 숨바꼭질 2
- 최소로 도착 가능한 시간
- 최소로 도착하는 경우의 수
'''
from collections import deque
def bfs(v):
	check[v] = [0, 1] # path, cnt
	q = deque()
	q.append(v)
	while q:
		x = q.popleft()
		if x == B:
			print(check[x][0])
			print(check[x][1])
			return
		for u in (x-1, x+1, 2*x):
			if u < 0 or u > 100000:
				continue
			if not check[u][1]:	# not visited
				check[u][0] = check[x][0] + 1	# path
				check[u][1] = check[x][1]		# cnt
				q.append(u)
			elif check[u][1] > 0 and check[u][0] == check[x][0] + 1:	# visited
				check[u][1] += check[x][1]

A, B = map(int, input().split())
check = [[0, 0] for _ in range(100001)]
bfs(A)