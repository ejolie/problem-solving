'''
boj1929. 소수 구하기
'''
from sys import stdin
from math import sqrt

def is_prime(n):
    if n == 1: return False
    for i in range(2, int(sqrt(n))+1):
        if n % i == 0:
            return False
    return True

M, N = map(int, input().split())
for n in range(M, N+1):
    if is_prime(n):
        print(n)