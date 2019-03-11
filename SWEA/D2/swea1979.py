'''
1979. 어디에 단어가 들어갈 수 있을까 (D2)

N X N 크기의 단어 퍼즐을 만들려고 한다. 
입력으로 단어 퍼즐의 모양이 주어진다.
퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리 수를 출력하는 프로그램을 작성하라.

1. N은 5 이상 15 이하의 정수이다. (5 ≤ N ≤ 15)
2. K는 2 이상 N 이하의 정수이다. (2 ≤ K ≤ N)
'''
tc = int(input())
for t in range(1, tc + 1):
  N, K = map(int, input().split())
  puzz = [[] * N for _ in range(N)]
  for i in range(N):
    puzz[i] = [int(n) for n in input().split()]

  ans = 0
  for i in range(N):
    rowcnt = colcnt = 0
    for j in range(N):
      if puzz[i][j] == 1:
        rowcnt += 1
      elif puzz[i][j] == 0:
        if rowcnt == K: ans += 1
        rowcnt = 0
      if puzz[j][i] == 1:
        colcnt += 1
      elif puzz[j][i] == 0:
        if colcnt == K: ans += 1
        colcnt = 0
    if rowcnt == K:
      ans += 1
    if colcnt == K:
      ans += 1
  print('#%d %d' % (t, ans))