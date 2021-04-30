'''
boj7576. 토마토

- 며칠이 지나면 토마토가 다 익게 되는지, 최소 일수
  모든 토마토가 처음부터 익은 상태 : 0 출력
  모두 익지 못하는 상황 : -1 출력
- 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토 X
- 하루가 지나면, 익은 토마토에 인접한 토마토들은 익게 된다
'''
from collections import deque
W, H = map(int, input().split())
box = [0] * H
total_box = W * H
total_tomato = 0
tomatoes = deque()
visited = [[False] * W for _ in range(H)]
for i in range(H):
    box[i] = list(map(int, input().split()))
    for j in range(W):
        if box[i][j] == -1:
            total_box -= 1
        elif box[i][j] == 1:
            total_tomato += 1
            tomatoes.append((i, j, 0))
            visited[i][j] = True
if total_box == total_tomato:
    print(0)
else:
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    maxday = 0
    while tomatoes:
        x, y, day = tomatoes.popleft()
        if day > maxday:
            maxday = day
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > H-1 or ny < 0 or ny > W-1:
                continue
            if not box[nx][ny] and not visited[nx][ny]:
                box[nx][ny] = 1
                total_tomato += 1
                tomatoes.append((nx, ny, day + 1))
                visited[nx][ny] = True
    print(maxday if total_box == total_tomato else -1)




