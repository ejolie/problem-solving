'''
1926. 간단한 369게임 

1. 숫자 1부터 순서대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
2. "3" "6" "9"가 들어가 있는 수를 말하지 않는 대신, 박수를 친다. 
이때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다. 
박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
'''
n = int(input())
nums = [list(str(i)) for i in range(1, n+1)]
result = []

for i in range(n):
  cnt = 0
  for j in range(len(nums[i])):
    if nums[i][j] in ('3', '6', '9'):
      cnt += 1

  if cnt == 0:
    result.append(''.join(nums[i]))
  else:
    result.append('-'*cnt)

print(' '.join(result))