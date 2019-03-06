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
result = []
stack = []
def solve(pair, visited, prev, n):
  if visited == (1 << n) - 1: # n개의 1과 같다면 - 모두 visited & 연결된 상태라면
    global result
    result = [a for a in stack]
    return

  for i in range(n):
    if visited == 0:                          # 1) 처음 방문 시 아무것도 방문 안 한 상태 
      stack.append(pair[i])   
      solve(pair, visited | (1 << i), i, n)   # 방문 표시 후, i를 기준으로 재귀 호출
      stack.pop()
    elif (visited & (1 << i)) == 0:           # 2) 처음 방문 이후 방문 안 한 상태
      if pair[prev][1] == pair[i][0]:         # 현재 prev 위치에 있는 암나사와 뒤에 있는 원소의 수나사 일치 시
        stack.append(pair[i])               
        solve(pair, visited | (1 << i), i, n) # 방문 표시 후, i를 기준으로 재귀 호출
        stack.pop()

tc = int(input())
for t in range(1, tc + 1):
    n = int(input())
    arr = input().split()
    pair = [[arr[i], arr[i+1]] for i in range(0, len(arr), 2)] # [수나사, 암나사] 한 쌍씩 묶은 리스트
    solve(pair, 0, -1, n)
    ret_arr = [result[i][0] + ' ' + result[i][1] for i in range(len(result))]
    ret_str = ' '.join(ret_arr)
    print(f'#{t} {ret_str}')
