'''
4831. 전기버스

- 0번에서 출발, N번까지 이동
- 한 번 충전으로 최대 K까지 이동
- 충전기가 설치된 M개의 정류장 번호
최소한 몇 번의 충전을 해야 종점에 도착할 수 있는가?
'''
def elecBus(k, n, m, arr):
    spots = [1 if i in arr else 0 for i in range(n+1)]
    spotInfo = dict(zip(range(n+1), spots))
    cnt, pos = 0, 0

    while True:
        checkSpots = [k for k in list(spotInfo.keys())[pos+1: pos+k+1] if spotInfo[k] == 1]
        if checkSpots == []:
            cnt = 0
            break
        pos = max(checkSpots)
        cnt += 1
        if pos + k >= n:
            break
    return cnt

tc = int(input())
for t in range(1, tc+1):
    k, n, m = map(int, input().split())
    arr = [int(i) for i in input().split()]
    result = elecBus(k, n, m, arr)
    print(f'#{t} {result}')