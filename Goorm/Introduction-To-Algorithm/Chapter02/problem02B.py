n = int(input())
heights = [int(item) for item in input().split()]

is_sorted = 'YES'
for i in range(n-1):
  if heights[i] > heights[i+1]:
    is_sorted = 'NO'
    break

print(is_sorted)