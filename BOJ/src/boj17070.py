'''
boj17070. 파이프 옮기기 1
- 파이프를 밀 수 있는 방향
  1. 오른쪽
  2. 아래
  3. 우하향 대각선
- 파이프는 밀면서 회전 가능, 회전은 45도만 가능
- 가능한 이동 방향
  가로로 놓여진 경우: 2가지
  세로로 놓여진 경우: 2가지
  대각선으로 놓인 경우: 3가지
- 가장 처음 파이프는 가로 방향으로 (0,0), (0,1) 차지할 때,
  파이프의 한쪽 끝을 (N-1, N-1)로 이동시키는 방법의 개수는?
- 빈칸은 0, 벽은 1
'''
from collections import deque
def is_wall(x, y, dir):
    if x < 0 or x > N-1 or y < 0 or y > N-1:
        return True
    if mat[x][y] == 1:
        return True
    if dir == 2:
        if mat[x-1][y-1] == 1 or mat[x-1][y] == 1 or mat[x][y-1] == 1:
            return True

def solve(i, j):
    countsdwsswvdsp[i][j] = 1
    q = deque()
    q.append((i, j, 0))
    cnt = 0
    while q:
        x, y, dir = q.popleft()
        if (x, y) == (N-1, N-1):
            cnt += 1
        if dir != 1 and not is_wall(x, y+1):

            q.append((x+1, y+1, 2))
        elif dir == 1:  # 세로
            if not is_wall(x+1, y, 1):
                q.append((x+1, y, 1))
            if not is_wall(x+1, y+1, 2):
                q.append((x+1, y+1, 2))
        else:           # 대각선
            if not is_wall(x, y+1, 0):
                q.append((x, y+1, 0))
            if not is_wall(x+1, y, 1):
                q.append((x+1, y, 1))
            if not is_wall(x+1, y+1, 2):
                q.append((x+1, y+1, 2))
    return cnt

N = int(input())
mat = [0] * N
for i in range(N):
    mat[i] = list(map(int, input().split()))
count = [[0] * N for _ in range(N)]
print(solve(0, 1))