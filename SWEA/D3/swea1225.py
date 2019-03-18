'''
swea1225. 암호생성기 (D3)
'''
def solve(arr):
    q = [-1] * 10
    f = r = -1
    for a in arr:
        r += 1
        q[r] = a
    while q[r] > 0:
        for i in range(1, 6):
            f += 1
            q[f]

for t in range(1, 11):
    input()
    nums = list(map(int, input().split()))
    solve(nums)