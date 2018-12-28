# 데이터 n, m, s을 입력받는다
# n : 수정이를 제외한 사람의 수 (필요 X)
# m : 미주의 키
# s : 지수의 키
m, s = map(int, input().split())

# 공백으로 구분된 n개의 정수를 입력받는다
data = [int(word) for word in input().split()]

# 사람들의 수를 셀 변수 count를 0으로 초기화한다 
count = 0

for height in data:
  if height == m or height == s:
    count += 1

print(count)