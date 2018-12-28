def find_value(arr, m):
  index = -1
  for i in range(0, len(arr)):
    if arr[i] == m:
      index = i
      break
  return index

if __name__ == '__main__':
  n, m = [int(word) for word in input().split()]
  arr = [int(word) for word in input().split()]
  print(find_value(arr, m))