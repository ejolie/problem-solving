'''
swea1983. 조교의 성적 매기기 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N, K = map(int, input().split())
    scores = [0] * N
    for i in range(N):
        mid, final, hw = map(int, input().split())
        scores[i] = [mid, final, hw]
