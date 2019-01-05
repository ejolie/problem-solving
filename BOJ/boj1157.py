import sys

words = list(sys.stdin.readline().rstrip().upper())
dic = {}

for w in words:
  if w not in dic:
    dic[w] = 1
  else:
    dic[w] += 1
    
maxKey = []
for key, value in dic.items():
  if value == max(dic.values()):
    maxKey.append(key)

print(maxKey[0] if len(maxKey) == 1 else '?')