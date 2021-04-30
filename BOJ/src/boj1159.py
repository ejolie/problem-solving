from sys import stdin
n = int(stdin.readline().rstrip())
dic = {}
for _ in range(n):
    s = stdin.readline().rstrip()
    if s[0] in dic:
        dic[s[0]] += 1
    else:
        dic[s[0]] = 1
s = []
for k, v in dic.items():
    if v >= 5:
        s += [k]
print('PREDAJA' if s == [] else f"{''.join(sorted(s))}")