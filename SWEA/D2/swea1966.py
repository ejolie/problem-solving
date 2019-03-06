'''
1966. 숫자를 정렬하자 

주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.
'''
def bubbleSort(arr, n):
  for i in range(n-1):      # i: 0,...,n-2 => last index of search range 조절
    for j in range(n-1-i):  # j: 0,...,n-1 / 0,...,n-2, / 0,1 => actual search range
      if arr[j] > arr[j+1]:
        arr[j], arr[j+1] = arr[j+1], arr[j]
  return arr

def insertionSort(arr, n):
  for i in range(1, n):     # i: 1,...,n-1 => start index of unsorted list 조절
    j = i-1                 # j: 0,...,n-2 => start index of sorted list
    key = arr[i]            # key: arr[1],...,arr[n-1] => value of start index
    while arr[j] > key and j >= 0: # while sorted list > key and index of key >= 0
      arr[j+1] = arr[j]            # assign key(arr[j+1]) = arr[j]
      j = j-1                      # move prev
    arr[j+1] = key
  return arr

def insertionSort2(arr, n):
  for i in range(1, n):
    while arr[i-1] > arr[i] and i > 0:
      arr[i], arr[i-1] = arr[i-1], arr[i]
      i -= 1
  return arr

def selectionSort(arr, n):
  for i in range(n-1):      # i: 0,...,n-2 => start index of sorted list 조절
    minIdx = i              # minIdx: 0,...,n-2 => minimum element of sorted list
    for j in range(i+1, n): # j: 1,...,n-1 / 2,...,n-2 / n-1  => actual search range
      if arr[j] < arr[minIdx]:
        minIdx = j
    arr[i], arr[minIdx] = arr[minIdx], arr[i]
  return arr

tc = int(input())
for t in range(1, tc+1):
  n = int(input())
  arr = list(map(int, input().split()))
  selectionSort(arr, n)
  st = ' '.join(arr)
  print(f'#{t} {st}')