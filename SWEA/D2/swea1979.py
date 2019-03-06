'''
1979. 어디에 단어가 들어갈 수 있을까  

N X N 크기의 단어 퍼즐을 만들려고 한다. 
입력으로 단어 퍼즐의 모양이 주어진다.
퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리 수를 출력하는 프로그램을 작성하라.

1. N은 5 이상 15 이하의 정수이다. (5 ≤ N ≤ 15)
2. K는 2 이상 N 이하의 정수이다. (2 ≤ K ≤ N)
'''
tc = int(input())
for t in range(1, tc+1):
  n, k = map(int, input().split())
  puzzle = [list(map(int, input().split())) for _ in range(n)]
  total = 0

  # 가로 확인 
  for i in range(n):
    verti = 0
    cnt = 0
    for j in range(puzzle[i]):
      if puzzle[i][j]:
        cnt += 1
        verty += cnt
      else:
        verti = 0
      '''
  1 0 1 1 1

전체 연속 개수: 1 0
실시간 카운트 : 1 0

'''
  # 세로 확인 
  print(f'#{t} {cnt}')