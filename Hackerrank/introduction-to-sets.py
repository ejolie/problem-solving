def average(array):
  s = set(array)
  avg = sum(s) / len(s)
  return avg

if __name__ == '__main__':
  n = int(input())
  array = [int(item) for item in input().split()]
  print(average(array))