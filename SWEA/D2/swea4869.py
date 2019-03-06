'''
4869. 종이붙이기
'''
def solve(n):
    memo = [0] * 1000
    memo[0], memo[1], memo[2], = 0, 1, 3
    for i in range(3, n+1):
        memo[i] = memo[i-1] + 2 * memo[i-2]
    return memo[n]

tc = int(input())
for t in range(1, tc+1):
    n = int(input()) // 10
    res = solve(n)
    print(f'#{t} {res}')