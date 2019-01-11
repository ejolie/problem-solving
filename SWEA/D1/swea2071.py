'''
2071. 평균값 구하기

10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
(소수점 첫째 자리에서 반올림한 정수를 출력한다.)
'''
tc = int(input())
for i in range(1, tc+1):
  arr = [int(i) for i in input().split()]
  print(f'#{i} {sum(arr) / len(arr) :.0f}')