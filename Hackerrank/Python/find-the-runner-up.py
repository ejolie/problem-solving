if __name__ == '__main__':
  n = int(input())
  arr = list(map(int, input().split()))

  max_num = max(arr)
  while arr.count(max_num) != 0:
    arr.remove(max_num)
    
  print(max(arr))