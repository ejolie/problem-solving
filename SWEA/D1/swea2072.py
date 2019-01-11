'''
2072. 홀수만 더하기 

10개의 수를 입력 받아, 
그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.
'''
tc = int(input())
for i in range(1, tc+1):
  arr = list(map(int, input().split()))
  print(f'#{i} {sum(list(filter(lambda x: x % 2 == 1, arr)))}')