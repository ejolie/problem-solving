'''
boj17071. 숨바꼭질 5
'''
from collections import deque
MAX_N = 500000
N, K = map(int, input().split())
visited = [-1 for _ in range(MAX_N+1)]

def dfs():
    q = deque()
    q.append((N, 0, K)) # node, cnt, dest
    while q:
        n, cnt, k = q.popleft()
        if n == k:
            return cnt
        else:
            for next_n in [n+1, n-1, 2*n]:
                if 0 <= next_n <= MAX_N and visited[next_n] != cnt:
                    visited[next_n] = cnt
                    q.append((next_n, cnt+1, k+cnt+1))

res = bfs()
print(res)