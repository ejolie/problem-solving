'''
윤년 (leap year)
- 연도가 4로 나눠져야 함
- 100으로 나눠지는 건 X
- 400으로 나눠지는 건 O
ex) 
O : 2000, 2400
X : 1800, 1900, 2100, 2200, 2300, 2500
'''
def is_leap(year):
    return year % 4 == 0 and (year % 400 == 0 or year % 100 != 0)

year = int(input())
print(is_leap(year))

'''
def is_leap(year):
    leap = False
    if year % 400 == 0:
        leap = True
    elif year % 4 == 0 and year % 100 != 0:
        leap = True
    return leap 
'''