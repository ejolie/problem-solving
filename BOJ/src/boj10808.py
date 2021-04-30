from sys import stdin
s = stdin.readline().rstrip()
arr = [0 for i in range(26)] # 97 ~ 122
for i in range(len(s)):
    arr[ord(s[i]) - 97] += 1
for i in range(len(arr)-1):
    print(arr[i], end=' ')
print(arr[len(arr)-1])