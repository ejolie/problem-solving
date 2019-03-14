'''
boj2573. 빙산
'''
from sys import stdin

def bfs(x, y):
	q = [(x, y)]
	while q != []:
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx > N-1 or ny < 0 or ny > M-1:
				continue
			if mat[nx][ny] and not visited[nx][ny]:
				q.append((nx, ny))

N, M = map(int, stdin.readline().split())
mat = [0] * N
for i in range(N):
	mat[i] = list(map(int, stdin.readline().split()))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
mounts = []
around = [[0] * M for _ in range(N)]

# Check location of mountains
for i in range(N):
	for j in range(N):
		if mat[i][j]: mounts.append((i, j))

# Check around seas of mountains
for m in mounts:
	x, y = m[0], m[1]
	for i in range(4):
		nx = x + dx[i]
		ny = y + dy[i]
		if nx < 0 or nx > N-1 or ny < 0 or ny > M-1:
			continue
		if not mat[nx][ny]:
			around[nx][ny] += 1

year = 0; is_two = False
while mounts:
	# Check number of mountains
	visited = [[0] * M for _ in range(N)]
	cnt = 0
	for m in mounts:
		x, y = m[0], m[1]
		if not visited[x][y]:
			cnt += 1
			visited[x][y] = 1
			bfs(x, y)
	if cnt > 1:
		is_two = True
		break

	# Melt mountains every year
	i = 0
	for m in mounts[:]:
		x, y = m[0], m[1]
		if mat[x][y]: # If still mountain
			mat[x][y] -= around[x][y]
			i += 1
		else:
			mounts.remove(m)
	year += 1

print(year if is_two else 0)