'''
boj2098. 외판원 순회

C(S, i): 출발점 1, 도착점 i이며 S에 있는 각 정점을 한 번만 방문하며 가는 최소 비용 경로
if len(S) == 2, then S = {1, i}
	C(S, i) = dist(1, i)
else:
	C(S, i) = min( C(S-{i}, j) + dist(j, i)) where 

TSP(curr, visited) = min( TSP(next, visited + next) + dist[curr][next] )
'''
def solve(v, visited):
    if visited == (1 << N) - 1:
        if G[v][0]:
            return G[v][0]
        return 987654321

    if dp[v][visited] != -1:
        return dp[v][visited]

    dp[v][visited] = 987654321
    for i in range(N):
        if visited & (1 << i):
            continue
        if G[v][i]:
            dp[v][visited] = min(dp[v][visited], solve(i, visited | (1 << i)) + G[v][i])
    return dp[v][visited]

N = int(input())
G = [0] * N
for i in range(N):
    G[i] = list(map(int, input().split()))
dp = [[-1] * (1 << N) for _ in range(N)]
print(solve(0, 1))