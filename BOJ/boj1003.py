'''
boj1003. 피보나치 함수
0, 1, 1, 2, 3
0  1  2  3  4  5

dp[2] = [ ]
dp[3] = [1, 2] # 0, 1
'''
dp = [[0, 0] for _ in range(41)]
dp[0] = [1, 0]
dp[1] = [0, 1]
for i in range(2, 41):
    dp[i][0] = dp[i-1][0] + dp[i-2][0]
    dp[i][1] = dp[i-1][1] + dp[i-2][1]

for _ in range(int(input())):
    n = int(input())
    print('%d %d' % (dp[n][0], dp[n][1]))
