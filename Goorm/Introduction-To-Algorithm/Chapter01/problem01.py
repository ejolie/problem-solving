# 코드가 실행되는 횟수를 기록할 변수
code_counter = 0

# 반복문 내부는 i라는 파라미터를 받아서 동작하는 함수와 비슷합니다.
def code(i):
  global code_counter
  code_counter += 1
  print('[{:3}] 현재 i는 {}입니다.'.format(code_counter, i))

l = -5 # 가장 처음의 i값 
r = 5 # 가장 마지막 i값 
step = 1 # i가 증가할 단위 
check = 3 # 중간에 체크해볼 i값 

# l~r 범위를 step 씩 증가하는 반복문 
for i in range(l, r+1, step):
  if i == check:
    print('지금 i가 {}인 채로 코드가 실행되려 합니다.'.format(i))
  code(i)