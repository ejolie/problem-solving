from sys import stdin
from math import sqrt
def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

n = int(stdin.readline().rstrip())
arr = [int(i) for i in stdin.readline().rstrip().split()]
cnt = 0
for num in arr:
    if is_prime(num):
        cnt += 1
print(cnt)