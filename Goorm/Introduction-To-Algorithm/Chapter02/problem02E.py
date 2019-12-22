def check_primenum(n):
  is_prime = True
  for i in range(1, n // 2):
    if n % i == 0:
      is_prime = False
      break
  print('YES' if is_prime else 'NO')

def test_case(testn):
  nums = []
  for i in range(testn):
    nums.append(int(input()))
  
  for i in range(testn):
    print('Case #{}'.format(i+1))
    check_primenum(nums[i])

if __name__ == '__main__':
  testn = int(input())
  test_case(testn)