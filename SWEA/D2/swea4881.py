'''
swea4881. 배열 최소 합
Backtracking
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    nums = [0] * N
    for i in range(N):
        nums[i] = list(map(int, input().split()))
    