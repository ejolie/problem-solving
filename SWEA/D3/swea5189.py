'''
swea5189. 전자카트 (D3)

- 사무실에서 출발해 각 구역을 한 번씩만 방문하고 사무실로 돌아올 때의 최소 배터리 사용량
- weighted graph
- 출발. 도착 : 1번
1 - 2, 3

1 - 2 - 3 - 1
1 - 3 - 2 - 1

  0 1 2
0
1
2
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    G = [0] * N
    for i in range(N):
        G[i] = list(map(int, input().split()))

    visited = [0] * N
    visited[0] = 1
    x = 0 # 시작점
    while y != 0: # 도착점
