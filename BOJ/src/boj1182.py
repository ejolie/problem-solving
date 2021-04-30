from sys import stdin

n, s = map(int, stdin.readline().rstrip().split())
arr = [int(i) for i in stdin.readline().rstrip().split()]
cnt = 0
for i in range(1, 1 << n):
    total = 0
    for j in range(n):
        if i & (1 << j):
            total += arr[j]
    if total == s:
        cnt += 1
print(cnt)