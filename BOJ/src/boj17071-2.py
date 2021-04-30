'''
boj17071. 숨바꼭질 5
'''
from collections import deque
MAX_N = 500000
N, K = map(int, input().split())
visited = [[-1 for _ in range(MAX_N + 1)] for _ in range(2)]
# visited[0][n] : 짝수 시간에 위치 n을 방문한 최소 시간
# visited[1][n] : 홀수 시간에 위치 n을 방문한 최소 시간

def bfs():
    q = deque()
    q.append((N, 0))
    visited[0][N] = 0

    while q:
        n, cnt = q.popleft()
        # flag : cnt가 홀/짝인지 결정
        flag = cnt % 2

        for next_n in [n+1, n-1, 2*n]:
            if 0 <= next_n <= MAX_N and visited[1-flag][next_n] == -1:
                visited[1-flag][next_n] = cnt + 1
                q.append((next_n, cnt + 1))

# 먼저 가능한 모든 점을 방문
bfs()

# 방문 이후, K를 늘려 보면서 이 점에 방문할 수 있는지 확인
t = 0
flag = 0
res = -1
while K <= MAX_N:
    if visited[flag][K] != -1:
        if visited[flag][K] <= t:
            res = t
            break
    flag = 1 - flag
    t += 1
    K += t
print(res)