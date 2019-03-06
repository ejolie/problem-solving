'''
swea4871. 그래프 경로
'''
def solve(adj, S, G):
    # DFS_iterative
    if G in adj[S]:
        return 1
    stack = [S]
    while stack:
        v = stack.pop()
        for w in adj[v]:
            stack.append(w)
            if G in adj[w]:
                return 1
    return 0

tc = int(input())
for t in range(1, tc+1):
    V, E = map(int, input().split())
    adj = {}
    for _ in range(E):
        a, b = map(int, input().split())
        if a not in adj:
            adj[a] = [b]
        else:
            adj[a] += [b]
        if b not in adj:
            adj[b] = []
    S, G = map(int, input().split())
    res = solve(adj, S, G)
    print(f'#{t} {res}')