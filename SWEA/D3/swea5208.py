'''
swea5208. 전기버스2

Unsolved

목적지에 도착하는데 필요한 최소한의 교환힛수
for i in range(s, N-1):
    if can_go_to(i): # while i != S: batt -= 1; if batt >= 0
        go(i, cnt + charges[s])
'''
def go(i, bat, cnt):
    if s == N:
        if cnt < mincnt:
            mincnt = cnt
        return
    for j in range(i, N):
        if bat <= j-i:
            go(j, bat-(j-i)+stations[j], cnt+1)

tc = int(input())
for t in range(1, tc+1):
    tmp = list(map(int, input().split()))
    N = tmp[0]
    stations = tmp[1:]

    mincnt = N-1
    go(0, stations[0], 1)

