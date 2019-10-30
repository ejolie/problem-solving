'''
boj13913. 숨바꼭질 4
'''
from collections import deque
def bfs(v):
    parent[v] = -1
    q = deque()
    q.append((v, 0))
    while q:
        x, cnt = q.popleft()
        if x == B:
            print(cnt)
            path = deque()
            while x != -1:
                path.append(x)
                x = parent[x]  # x = prev of x
            while path:
                print(path.pop(), end=' ')
            return
        for u in (x-1, x+1, 2*x):
            if u < 0 or u > 100000:
                continue
            if not parent[u]:
                parent[u] = x  # parent[curr] = prev
                q.append((u, cnt+1))

A, B = map(int, input().split())
parent = [0] * 100001
bfs(A)