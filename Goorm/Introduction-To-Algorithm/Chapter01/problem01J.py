def compute_sum(n):
  sum = 0
  for i in range(1, n+1):
    sum += i
  return sum

if __name__ == '__main__':
  num = int(input())
  total_sum = 0
  for i in range(1, num+1):
    total_sum += compute_sum(i)
  print(total_sum)