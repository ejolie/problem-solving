'''
2068. 최대수 구하기

10개의 수를 입력 받아, 
그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
''' 
tc = int(input())
for i in range(1, tc+1):
  arr = [int(i) for i in input().split()]
  print(f'#{i} {max(arr)}')