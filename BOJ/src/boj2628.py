'''
boj2628. 종이자르기
'''
def find_max(arr, N):
    maxleng = 0
    s = 0
    for i in range(1, N):
        if arr[i]:
            if i - s > maxleng:
                maxleng = i - s
            s = i
    return maxleng

W, H = map(int, input().split())
N = int(input())
garo = [0] * (W+1)
sero = [0] * (H+1)
for _ in range(N):
    a, b = map(int, input().split())
    if a: garo[b] = 1 # sero line
    else: sero[b] = 1 # garo line
garo[W], sero[H] = 1, 1
maxgaro = find_max(garo, W+1)
maxsero = find_max(sero, H+1)
print(maxgaro * maxsero)