'''
swea5209. 최소 생산 비용
'''
def solve(i, cnt):
    global minsum
    if i == N:
        if cnt < minsum:
            minsum = cnt
        return
    for j in range(N):
        if not check[j] and cnt + mat[i][j] <= minsum:
            check[j] = 1
            solve(i+1, cnt + mat[i][j])
            check[j] = 0

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    mat = [0] * N
    for i in range(N):
        mat[i] = list(map(int, input().split()))
    check = [0] * N
    minsum = 1500
    solve(0, 0)
    print('#%d %d' % (t, minsum))