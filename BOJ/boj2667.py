'''
boj2667. 단지번호붙이기
'''
from sys import stdin

def bfs(x, y):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    queue = [[x, y]]
    visited[x][y] = 1
    hcnt = 0
    while queue != []:
        cx, cy = queue.pop(0)
        hcnt += 1
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if nx < 0 or nx > N-1 or ny < 0 or ny > N-1:
                continue
            if mat[nx][ny] and not visited[nx][ny]:
                visited[nx][ny] = 1
                queue.append([nx, ny])
    return hcnt

N = int(stdin.readline().rstrip())
mat = [0] * N
for i in range(N):
    mat[i] = [int(n) for n in list(stdin.readline().rstrip())]

cnt = 0
house = []
visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if mat[i][j] and not visited[i][j]:
            cnt += 1
            h = bfs(i, j)
            house.append(h)
print(cnt)
for c in sorted(house):
    print(c)