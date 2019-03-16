'''
swea5255. 타일 붙이기
dp[n] = dp[n-1] + 2*dp[n-2] + dp[n-3]
'''
dp = [0] * 31
dp[1], dp[2], dp[3] = 1, 3, 6
for i in range(4, 31):
    dp[i] = dp[i-1] + 2*dp[i-2] + dp[i-3] 
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    print('#{} {}'.format(t, dp[N]))