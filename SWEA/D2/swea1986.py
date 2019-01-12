'''
1986. 지그재그 숫자 

1부터 N까지의 숫자에서 홀수는 더하고 짝수는 뺐을 때 
최종 누적된 값을 구해보자.
'''
t = int(input())
for i in range(1, t+1):
  n = int(input())
  total = 0
  for j in range(1, n+1):
    if j % 2 == 1:
      total += j
    else:
      total -= j
  print(f'#{i} {total}')