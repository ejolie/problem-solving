def get_max(a, b):
  return a if a > b else b

p, q = map(int, input().split())
answer = get_max(p, q)
print(answer)