n = int(input())
magazines = [int(item) for item in input().split()] # 오름차순 

type_count = 0
for i in range(n):
  if i == 0 or magazines[i-1] != magazines[i]:
    type_count += 1

print(type_count)