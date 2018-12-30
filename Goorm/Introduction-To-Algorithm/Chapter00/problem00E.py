def testcase():
  # 한 테스트 케이스에 대한 입력, 처리, 출력을 이 함수에서 한다
  a, b, c = map(int, input().split())
  answer = a + b + c
  print(answer)

# 테스트 케이스의 수를 입력받는다 
tc = int(input())

for i in range(0, tc):
  # 테스트 케이스의 수만큼 반복하며 테스트 케이스의 번호를 출력한다 
  print('Case #' + str(i+1))
  # 테스트 케이스를 수행한다 
  testcase()