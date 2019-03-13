'''
boj1260: DFS와 BFS
'''
from sys import stdin

def dfs(i):
    s = [i]
    visited = [0] * (N+1)
    while s:
        v = s.pop()
        if not visited[v]:
            visited[v] = 1
            print(v, end=' ')
            for w in sorted(G[v], reverse=True):
                s.append(w)

def bfs(i):
    q = [i]
    visited = [0] * (N+1)
    visited[i] = 1
    while q:
        v = q.pop(0)
        print(v, end=' ')
        for w in sorted(G[v]):
            if not visited[w]:
                visited[w] = 1
                q.append(w)

N, M, V = map(int, stdin.readline().split())
G = [[] for _ in range(N+1)]
for _ in range(M):
    v, w = map(int, stdin.readline().split())
    G[v].append(w)
    G[w].append(v)
dfs(V)
print()
bfs(V)