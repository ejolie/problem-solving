'''
boj2559. 수열

s_idx = 0 ~ n-k
l_idx = k-1 ~ n-1

Sn = Sn-1 - an-1 + ak-2+n 
'''
from sys import stdin

N, K = map(int, stdin.readline().rstrip().split())
temps = list(map(int, stdin.readline().rstrip().split()))
prevSum = 0
for j in range(0, K):
	prevSum += temps[j]
maxSum = prevSum
for i in range(1, N-K+1):
	tmpSum = prevSum - temps[i-1] + temps[i+K-1]
	if tmpSum > maxSum:
		maxSum = tmpSum
	prevSum = tmpSum
print(maxSum)