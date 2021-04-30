import sys

def insertionSort(arr, n):
    for i in range(1, n):
        j = i-1 
        key = arr[i] # 1...n-1
        while arr[j] > key and j >= 0:
            arr[j+1] = arr[j]
            j = j - 1
        arr[j+1] = key
    return arr

def bubbleSort(arr, n):
    for i in range(n-1): # 0...n-2
        for j in range(n-1-i): # 0...n-1, 0...n-2, ..., 0...1
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

def selectionSort(arr, n):
    for i in range(n-1): 
        minInd = i
        for j in range(i+1, n):
            if arr[j] < arr[minInd]:
                minInd = j
        arr[i], arr[minInd] = arr[minInd], arr[i]        
    return arr

n = int(input())
arr = []
for i in range(n):
    arr.append(sys.stdin.readline())
bubbleSort(arr, n)
for item in arr:
    print(item)