'''
swea5188. 최소합 (D3)
'''
def dfs(x, y, tmpsum):
    global minsum
    visited[x][y] = 1
    if (x, y) == (N-1, N-1):
        if tmpsum < minsum:
            minsum = tmpsum
        return
    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > N-1 or ny < 0 or ny > N-1:
            continue
        if not visited[nx][ny] and tmpsum <= minsum:
            visited[nx][ny] = 1
            dfs(nx, ny, tmpsum + nums[nx][ny])
            visited[nx][ny] = 0

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    nums = [0] * N
    for i in range(N):
        nums[i] = list(map(int, input().split()))

    visited = [[0] * N for _ in range(N)]
    dx = [0, 1]
    dy = [1, 0]
    minsum = 100000000000
    dfs(0, 0, nums[0][0])
    print('#{} {}'.format(t, minsum))