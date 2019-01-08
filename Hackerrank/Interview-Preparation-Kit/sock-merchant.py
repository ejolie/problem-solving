import sys

def sockMerchant(n, ar):
    dic = {}
    for a in ar:
        if a not in dic:
            dic[a] = 1
        else:
            dic[a] += 1

    pair, count = 0, 0
    for v in dic.values():
        count = v // 2
        if count > 0:
            pair += count

    return pair

n = int(sys.stdin.readline())
socks = list(map(int, sys.stdin.readline().split()))
result = sockMerchant(n, socks)
print(result)