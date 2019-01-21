'''
2005. 파스칼의 삼각형 

N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.
파스칼의 삼각형이란 아래와 같은 규칙을 따른다.
1. 첫 번째 줄은 항상 숫자 1이다.
2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
'''
def pascal(n):
  arr = [[1], [1,1]]
  if n == 1:
    print('1')
  elif n == 2:
    print('1\n1 1')
  else:
    for i in range(2, n): 
      tmp = [1, 1]
      for j in range(i-1):
        tmp.insert(j+1, arr[i-1][j] + arr[i-1][j+1])
      arr.insert(i, tmp)
    for i in range(n):
      for j in range(len(arr[i])):
        arr[i][j] = str(arr[i][j])
      arr[i] = ' '.join(arr[i])
    print('\n'.join(arr))

tc = int(input())
for t in range(1, tc+1):
  n = int(input())
  print(f'#{t}')
  pascal(n)