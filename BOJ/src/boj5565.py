'''
boj5565. 영수증
'''
total = int(input())
for _ in range(9):
    total -= int(input())
print(total)