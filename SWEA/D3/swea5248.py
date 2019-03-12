'''
swea5248. 그룹 나누기

vertex : 1 ~ N
edge : m개
'''
def bfs(i):
    q = [i]
    while q:
        v = q.pop(0)
        for w in G[v]:
            if not visited[w]:
                visited[w] = 1
                q.append(w)

tc = int(input())
for t in range(1, tc+1):
    N, M = map(int, input().split())
    G = [[] for _ in range(N+1)]
    tmp = list(map(int, input().split()))
    for i in range(M):
        v, w = tmp[2*i], tmp[2*i+1]
        G[v].append(w)
        G[w].append(v)

    visited = [0] * (N+1)
    cnt = 0
    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = 1
            cnt += 1
            bfs(i)
    print('#%d %d' % (t, cnt))