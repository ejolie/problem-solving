'''
swea4875. 미로 (D2)
'''
def dfs(x, y): # backtracking
    visited[x][y] = 1
    if (x, y) == (fx, fy):
        return 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > N-1 or ny < 0 or ny > N-1:
            continue
        if maze[nx][ny] != 1 and not visited[nx][ny]:
            if dfs(nx, ny):
                return 1
    visited[x][y] = 0
    return 0

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    maze = [0] * N
    visited = [[0] * N for _ in range(N)]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    sx, sy = 0, 0
    fx, fy = 0, 0

    for i in range(N):
        maze[i] = list(map(int, list(input())))
        for j in range(N):
            if maze[i][j] == 3:
                fx = i; fy = j
            if maze[i][j] == 2:
                sx = i; sy = j
    print('#%d %d' % (t, dfs(sx, sy)))
