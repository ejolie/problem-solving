from sys import stdin
s = stdin.readline().rstrip()
vowels = 'aeiou'
cnt = 0
for i in range(len(s)):
    if s[i] in vowels:
        cnt += 1
print(cnt)