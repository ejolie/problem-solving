'''
swea1953. 탈주범 검거
- 맨홀 뚜껑을 통해 지하터널로 들어감
탈출 1시간 뒤 위치 : 맨홀 뚜껑 위치
- 터널끼리 연결되어 있는 경우 이동 가능,
탈주범이 있을 수 있는 위치의 개수 계산해야 함
- 시간당 1의 거리 이동
- 지하 터널 : 총 7 종류
- 경과된 시간 후, 탈주범이 위치할 수 있는 장소의 개수 계산
- 제약 조건
5 <= 세로 N, 가로 M <= 50
0 <= R <= N-1, 0 <= C <= M-1
1 <= 소요시간 L <= 20
'''
from collections import deque
def is_connected(a, b, dir):
    if a == 1 or b == 1: return True
    if dir == 0: # a, a의 위쪽
        if a in (3, 5, 6): return False
        else:
            if b in (2, 5, 6): return True
            return False
    elif dir == 1: # a, a의 오른쪽
        if a in (2, 6, 7): return False
        else:
            if b in (3, 6, 7): return True
            return False
    elif dir == 2: # a, a의 아래쪽
        if a in (3, 4, 7): return False
        else:
            if b in (2, 4, 7): return True
            return False
    elif dir == 3: # a, a의 왼쪽
        if a in (2, 4, 5): return False
        else:
            if b in (3, 4, 5): return True
            return False

def solve(r, c):
    q = deque()
    q.append((r, c))
    visited[r][c] = True
    cnt, hour = 1, 0
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    while hour < L:
        x, y = q.popleft()
        hour += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > N-1 or ny < 0 or ny > M-1:
                continue
            if not visited[nx][ny] and mat[nx][ny] and is_connected(mat[x][y], mat[nx][ny], i):
                q.append((nx, ny))
                visited[nx][ny] = True
                cnt += 1
    print(cnt)

tc = int(input())
for t in range(1, tc+1):
    N, M, R, C, L = map(int, input().split())
    mat = [0] * N
    for i in range(N):
        mat[i] = list(map(int, input().split()))
    visited = [[False] * M for _ in range(N)]
    print('#%d' % t, end=' ')
    solve(R, C)