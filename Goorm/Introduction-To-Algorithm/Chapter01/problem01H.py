def solve(data, n):
  sum = 0
  avg = 0
  for value in data:
    sum += value
  avg = sum / len(data)

  min = abs(avg - data[0])
  index = 0
  for i in range(1, len(data)):
    tmp = abs(avg - data[i])
    if tmp < min:
      min = tmp
      index = i
  print('{} {}'.format(index+1, data[index]))

if __name__ == '__main__':
  n = int(input())
  data = [int(item) for item in input().split()]
  solve(data, n)