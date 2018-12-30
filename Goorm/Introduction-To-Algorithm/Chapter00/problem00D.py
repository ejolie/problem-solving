n = int(input())
arr = list(map(int, input().split()))
arr.reverse()

for i in range(n-1):
  print(arr[i], end=' ')
print(arr[n-1])