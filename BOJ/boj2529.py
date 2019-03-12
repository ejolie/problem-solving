'''
boj2529. 부등호

Unsolved
'''
from sys import stdin
def solve(k):
    if k == K+2:
        return
    for i in range(k, K):
        for j in range(10):
            if not check[j]:
                check[j] = 1
                solve(k+1)
                check[j] = 0


K = int(stdin.readline().rstrip())
symbols = list(stdin.readline().rstrip().split())
check = [0] * 10
nums = [0] * (K + 1)
maxnum = 0
solve(0)


