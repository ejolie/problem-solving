'''
swea5105. 노드의 거리
'''
def bfs(x, y, cnt):
	dx = [-1, 0, 1, 0]
	dy = [0, 1, 0, -1]
	visited[x][y] = 1
	q = [(x, y, cnt)]
	ret = 0
	while q != []:
		cx, cy, cnt = q.pop(0)
		if (cx, cy) == (fx, fy):
			ret = cnt - 1
			break
		for i in range(4):
			nx = cx + dx[i]
			ny = cy + dy[i]
			if nx < 0 or nx > N-1 or ny < 0 or ny > N-1:
				continue
			if maze[nx][ny] != 1 and not visited[nx][ny]:
				visited[nx][ny] = 1
				q.append((nx, ny, cnt + 1))
	return ret

tc = int(input())
for t in range(1, tc+1):
	N = int(input())
	maze = [0] * N
	sx, sy = 0, 0
	fx, fy = 0, 0
	for i in range(N):
		maze[i] = list(map(int, list(input())))
		for j in range(N):
			if maze[i][j] == 2:
				sx, sy = i, j
			elif maze[i][j] == 3:
				fx, fy = i, j
	visited = [[0] * N for _ in range(N)]
	print('#{} {}'.format(t, bfs(sx, sy, 0)))