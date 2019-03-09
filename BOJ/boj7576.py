'''
boj7576. 토마토
'''
from sys import stdin

def bfs(x, y):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    queue = [(x, y, 0)]
    visited[x][y] = 1
    cnt = 0
    while queue != []:
        cnt += 1
        cx, cy, day = queue.pop(0)
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if nx < 0 or nx > N-1 or ny < 0 or ny > M-1:
                continue
            if box[nx][ny] == 0 and not visited[nx][ny]:
                box[nx][ny] = 1
                visited[nx][ny] = 1
                queue.append((nx, ny, day + 1))
        print('> {}번째 날'.format(day+1))
        for b in box:
            print(b)
        print()

    return day, cnt

M, N = map(int, stdin.readline().rstrip().split())
box = [0] * N
loc = []
tomatoes = M * N
for i in range(N):
    box[i] = list(map(int, stdin.readline().rstrip().split()))
    for j in range(M):
        if box[i][j] == 1:
            loc.append((i, j))
        if box[i][j] == -1:
            tomatoes -= 1
print('# loc:',loc)
print('# start tomatoes:', tomatoes)
days = 0
visited = [[0] * M for _ in range(N)]
for q in loc:
    x, y = q[0], q[1]
    if not visited[x][y]:
        print('>>> not visited: {},{}'.format(x, y))
        day, cnt = bfs(x, y)
        print('>> day: {}, cnt: {}'.format(day, cnt))
        days += day
        tomatoes -= cnt
print('# finish tomatoes:', tomatoes)
print(-1 if tomatoes > 0 else days)