n = int(input())
if n % 2 == 0 and (n < 5 or n > 20):
  print('Not', end=' ')
print('Weird')

''' 
# method -1
if n % 2:
  print('Weird')
else:
  if n in range(2, 6):
    print('Not Weird')
  if n in range(6, 21):
    print('Weird')
  if n > 20:
    print('Not Weird')

# method -2
print('Weird' if n % 2 == 1 or (n > 5 and n <= 20) else 'Not Weird')
'''