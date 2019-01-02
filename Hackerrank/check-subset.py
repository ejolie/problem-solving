def test_case(tc):
  for i in range(tc):
    a = int(input())
    set_a = set(map(int, input().split()))

    b = int(input())
    set_b = set(map(int, input().split()))

    if set_a.issubset(set_b):
      print(True)
    else:
      print(False)

if __name__ == '__main__': 
  tc = int(input())
  test_case(tc)