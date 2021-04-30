from sys import stdin
s = stdin.readline().rstrip()
arr = []
for i in range(-1, -len(s)-1, -1):
    arr.append(s[i:])
arr.sort()
for i in arr:
    print(i)