def check_weights(weights, n, p, q):
  total = 0 # 탑승할 수 있는 회원의 몸무게의 합
  count = 0 # 탑승할 수 있는 사람의 수

  for value in weights:
    if value <= p:
      count += 1
      total += value
      
  print(count, total, sep=' ')
  print('YES' if total <= q else 'NO')

if __name__ == '__main__':
  n, p, q = [int(word) for word in input().split()]
  weights = [int(word) for word in input().split()]

  check_weights(weights, n, p, q)