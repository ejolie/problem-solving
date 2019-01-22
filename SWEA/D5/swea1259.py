'''
1259. 금속막대

원형 금속 막대는 한 쪽 면에 수나사, 다른 쪽엔 암나사로 이루어져 있다.
수나사와 암나사는 굵기가 서로 다르다.
- 나사의 굵기: 수나사의 굵기 x 암나사의 굵기
- 연결: +

원형 금속 막대를 연결하기 위해서는 수나사의 굵기와 암나사의 굵기가 서로 일치해야 한다.
수나사와 암나사의 크기가 서로 다른 여러 개의 원형 금속 막대를 가장 많이 연결하려고 한다.
어떤 순서로 연결해야 가장 많이 연결하는지를 찾는 프로그램을 작성하시오.
'''
def perm(arr):
    if len(arr) == 0:
        return []
    if len(arr) == 1:
        return [arr]
    l = []
    for i in range(len(arr)):
        m = arr[i]
        rest = arr[:i] + arr[i+1:]
        for p in perm(rest):
            l.append([m] + p)
    return l

def solve(n, arr):
    result = []
    for p in perm(arr):
        cnt = 0
        for i in range(n-1):
            if p[i][1] == p[i+1][0]:
                cnt += 1
        if cnt == n-1:
            result = p
            break
    print(result)
                

tc = int(input())
for t in range(1, tc+1):
    n = int(input())
    arr = list(map(int, input().split()))
    pair = [[arr[i], arr[i+1]] for i in range(0, len(arr), 2)]
    solve(n, pair)