def get_max(data, n):
  max_num = data[0]
  for value in data:
    if value > max_num:
      max_num = value
  return max_num

if __name__ == '__main__':
  n = int(input())
  data = list(map(int, input().split()))
  # data = [int(word) for word in input().split()]
  answer = get_max(data, n)
  print(answer)