'''
boj2606. 바이러스

'''
from sys import stdin
def bfs(v):
    queue = [v]
    visited[v] = 1
    cnt = -1
    while queue:
        s = queue.pop(0)
        cnt += 1
        for w in G[s]:
            if not visited[w]:
                queue.append(w)
                visited[w] = 1
    return cnt

N = int(stdin.readline().rstrip())
E = int(stdin.readline().rstrip())
G = [[] for _ in range(N+1)]
visited = [0] * (N+1)
for _ in range(E):
    v, w = map(int, stdin.readline().rstrip().split())
    G[v].append(w); G[w].append(v)
print(bfs(1))