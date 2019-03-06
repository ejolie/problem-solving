'''
swea1267. 작업순서
'''
def DFS(v):
    print(f' {v}', end='')
    visited[v] = 1
    for w in G[v]:
        if not visited[w]:
            DFS(w)

for t in range(1, 11):
    V, E = map(int, input().split())
    G = [[] for _ in range(V+1)] # adjacency list
    indeg = [0] * (V+1) # in-degree info
    visited, stack = [0] * (V+1), []
    edges = list(map(int, input().split()))
    for i in range(E):
        u, v = edges[i*2: i*2 + 2]
        G[u] += [v]
        indeg[v] += 1
    print(f'#{t}', end='')
    for i in range(1, V+1):
        if indeg[i] == 0:
            DFS(i)
    print()
    # res = ''
    # for v in stack[::-1]:
    #     res += f' {v}'
    # print(f'#{t}{res}')