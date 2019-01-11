'''
2029. 몫과 나머지 출력하기 

a, b를 입력 받아, 
a를 b로 나눈 몫과 나머지를 출력하는 프로그램을 작성하라.
'''
tc = int(input())
for i in range(1, tc+1):
  a, b = [int(i) for i in input().split()]
  print(f'#{i} {a // b} {a % b}')