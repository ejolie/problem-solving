n = int(input())
heights = [int(item) for item in input().split()]
months = [int(item) for item in input().split()]
this_month = int(input())

max_heights = -1
for i in range(len(heights)-1, 1, -1):
  if months[i] == this_month and heights[i] > max_heights:
    max_heights = heights[i]

print(max_heights)