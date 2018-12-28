def get_sum(data, n):
  sum = 0
  i = 0
  while i < n:
    sum += data[i]
    i += 1
  return sum

if __name__ == '__main__':
  n = int(input())
  data = [int(word) for word in input().split()]
  answer = get_sum(data, n)
  print(answer)