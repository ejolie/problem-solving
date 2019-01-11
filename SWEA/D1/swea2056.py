'''
2056. 연월일 달력

연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면
[그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,
날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.
''' 
tc = int(input())
for i in range(1, tc+1):
  m1 = [1, 3, 5, 7, 8, 10, 12] # 31
  m2 = [4, 6, 9, 11]           # 30

  date = input()
  year, month, day = int(date[0:4]), int(date[4:6]), int(date[6:])

  isInvalid = False

  if month not in range(1, 13):
    isInvalid = True
  elif month in m1 and day > 31:
    isInvalid = True
  elif month in m2 and day > 30:
    isInvalid = True
  elif month == 2 and day > 28:
    isInvalid = True
  else:
    result = f'{year:0>4d}/{month:0>2d}/{day:0>2d}'

  print(f'#{i} {-1 if isInvalid else result}')