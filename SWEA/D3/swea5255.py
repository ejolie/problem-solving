'''
swea5255. 타일 붙이기
'''
def solve(N):
    memo = [0] * (N+1)
    memo[0], memo[1], memo[2] = 0, 1, 3
    for i in range(3, N+1):
        if i & 1 == 0: # 짝수
            memo[i] = 2 * memo[i-2] + memo[i-1] + (i // 3)
        else:
            memo[i] = memo[i-3] + memo[i-2] + memo[i-1] + (i // 4)
    return memo[N]

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    print('#{} {}'.format(t, solve(N)))