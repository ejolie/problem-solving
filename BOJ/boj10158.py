'''
boj10158. 개미
'''
from sys import stdin

w, h = [int(n) for n in stdin.readline().rstrip().split()]
curX, curY = [int(n) for n in stdin.readline().rstrip().split()]
t = int(stdin.readline().rstrip())

dx = dy = 1
while t > 0:
    if curX + dx > w or curX + dx < 0:
        dx = -dx
    if curY + dy > h or curY + dy < 0:
        dy = -dy
    curX += dx
    curY += dy
    t -= 1

print('%d %d' % (curX, curY))