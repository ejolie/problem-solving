'''
swea5188. 최소합 (D2)
'''
def dfs(x, y, cnt):
    dx = [0, 1]
    dy = [1, 0]
    visited[x][y] = 1
    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > N-1 or ny < 0 or ny > N-1:
            continue
        if not visited[nx][ny]:
            visited[nx][ny] = 1
            dfs(nx, ny, cnt + arr[nx][ny])
    sums.append(cnt)

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    arr = [0] * N
    for i in range(N):
        arr[i] = list(map(int, input().split()))
    visited = [[0] * N for _ in range(N)]
    sums = []
    dfs(0, 0, arr[0][0])
    print(sums)