import sys

s = sys.stdin.readline()
alphList = [i for i in range(97, 123)] # 97-122: a-z

for i in range(len(s)):
    if ord(s[i]) in alphList:
        pass