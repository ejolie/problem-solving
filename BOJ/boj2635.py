'''
boj2635. 수 이어가기

an+2 = an - an+1

an+2    (-1 1) an+1
an+1 =  ( 1 0) an
'''
from sys import stdin

n = int(stdin.readline().rstrip())
startn = n // 2 + 1
maxl = tmpl = [n] + [-1] * 100

maxcnt = 0
for k in range(startn, n+1):
    tmpl[1] = k
    tmpcnt = 2
    while tmpl[tmpcnt - 2] - tmpl[tmpcnt - 1] >= 0:
        tmpl[tmpcnt] = tmpl[tmpcnt - 2] - tmpl[tmpcnt - 1]
        tmpcnt += 1
    if tmpcnt > maxcnt:
        maxcnt = tmpcnt
        maxl = tmpl[:]

print(maxcnt)
for n in maxl:
    if n == -1:
        break
    print(n, end=' ')