'''
swea4881. 배열 최소 합
Backtracking
'''
def solve(r, tmpsum):
    global minsum
    if r == N:
        if tmpsum < minsum:
            minsum = tmpsum
        return
    for j in range(N):
        if not check[j] and tmpsum + nums[r][j] <= minsum:
            check[j] = 1
            solve(r+1, tmpsum + nums[r][j])
            check[j] = 0

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    nums = [0] * N
    for i in range(N):
        nums[i] = list(map(int, input().split()))
    check = [0] * N
    minsum = 100
    solve(0, 0)
    print('#%d %d' % (t, minsum))