from sys import stdin
s = stdin.readline().rstrip()
arr = [-1] * 26
for i in range(len(s)):
    idx = ord(s[i]) % 97
    if arr[idx] == -1:
        arr[idx] = i
for i in arr:
    print(i, end=' ')