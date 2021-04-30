'''
boj2293. 동전1
f[n] = f[n-1] + f[n-2] + f[n-5]
method 1. Tabulation: Bottom up
'''
from sys import stdin
n, k = map(int, stdin.readline().split())
dp = [0] * (k+1)
dp[0] = 1
for _ in range(n):
	coin = int(stdin.readline())
	for i in range(0, k-coin+1):
		dp[i+coin] += dp[i]
print(dp[k])