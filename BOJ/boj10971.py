'''
boj10971. 외판원 순회 2
'''
from sys import stdin
def solve(v, cnt, dist):
    global minl
    if cnt == N and G[v][0]:
        if dist + G[v][0] < minl:
            minl = dist + G[v][0]
        return
    for i in range(N):
        if not visited[i] and G[v][i]:
            visited[i] = 1
            if dist + G[v][i] <= minl:
                solve(i, cnt + 1, dist + G[v][i])
            visited[i] = 0

N = int(stdin.readline().strip())
G = [0] * N
for i in range(N):
    G[i] = list(map(int, stdin.readline().strip().split()))
visited = [0] * N
visited[0] = 1
minl = 987654321
solve(0, 1, 0)
print('%d' % minl)