'''
boj2669. 직사각형 네개의 합집합의 면적 구하기
'''
from sys import stdin
map = [[0] * 101 for _ in range(101)] # 1 <= x, y <= 100
cnt = 0
for i in range(4):
    ax, ay, bx, by = [int(n) for n in stdin.readline().rstrip().split()]
    for x in range(ax, bx):
        for y in range(ay, by):
            if not map[x][y]:
                map[x][y] = 1
                cnt += 1
print(cnt)