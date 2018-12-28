n = int(input())

first_index = -1
last_index = -1
for i in range(1, n+1):
  name = input()
  if name == 'AJOU':
    if first_index == -1:
      first_index = i
    else:
      last_index = i

print(first_index, last_index, sep=' ')