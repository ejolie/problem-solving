'''
boj2636. 치즈

- 판의 가장자리에는 치즈가 놓여 있지 X
- 치즈에는 하나 이상의 구멍
- c : 테두리 공기와 접촉된 칸, 한 시간 후 녹아 없어짐

* 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간
* 모두 녹기 한 시간 전에 남아있는 치즈의 칸의 개수
'''
from sys import stdin

def bfs(X, Y):
	q = [(X, Y)]
	cnt = 0
	while q != []:
		cnt += 1
		x, y = q.pop(0)
		zeros = 0
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx > H-1 or ny < 0 or ny > W-1:
				continue
			if not mat[nx][ny]:
				zeros += 1
			if not visited[nx][ny] and mat[nx][ny]:
				q.append((nx, ny))
		if zeros:
			around.append((x, y, around))
	return cnt

H, W = map(int, stdin.readline().split())
mat = [0] * (H+1)
C = []
for i in range(H):
    mat[i] = list(map(int, stdin.readline().split()))
    for j in range(1, W):
    	if mat[i][j]:
    		C.append((i, j))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
hour = -1
is_melted = False
while True:
	hour += 1
	visited = [[0] * W for _ in range(H)]
	around = []
	num_of_C = 0
	for c in C:
		x, y = c
		if not visited[x][y]:
			visited[x][y] = 1
			num_of_C += 1
			num_of_C += bfs(x, y)
