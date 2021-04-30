'''
boj2206. 벽 부수고 이동하기
'''
from collections import deque
N, M = map(int, input().split())
mat = [0] * N
for i in range(N):
	mat[i] = list(map(int, list(input())))
visited = [[False] * M for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

q = deque()
q.append((0, 0, 1, False))
visited[0][0] = True
ans = -1
while q:
	x, y, dist, is_break = q.popleft()
	if (x, y) == (N-1, M-1):
		ans = dist
		break
	for i in range(4):
		nx = x + dx[i]
		ny = y + dy[i]
		if nx < 0 or nx > N-1 or ny < 0 or ny > M-1 or visited[nx][ny]:
			continue
		if not mat[nx][ny]: # not wall
			visited[nx][ny] = True
			q.append((nx, ny, dist + 1, is_break))
		else: # wall
			if not is_break:
				visited[nx][ny] = True
				q.append((nx, ny, dist + 1, True))
print(ans)