'''
boj2636. 치즈

- 판의 가장자리에는 치즈가 놓여 있지 X
- 치즈에는 하나 이상의 구멍
- c : 테두리 공기와 접촉된 칸, 한 시간 후 녹아 없어짐

* 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간
* 모두 녹기 한 시간 전에 남아있는 치즈의 칸의 개수
'''
from sys import stdin

H, W = map(int, stdin.readline().split())
mat = [0] * (H+1)
for i in range(H):
    mat[i] = list(map(int, stdin.readline().split()))

while True:

