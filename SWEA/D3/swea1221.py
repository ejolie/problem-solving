'''
1221. GNS

숫자 체계가 우리와 다른 어느 행성이 있다.
아래는 이 행성에서 사용하는 0 ~ 9의 값을 순서대로 나타낸 것이다.
"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
0 ~ 9 의 값을 나타내는 단어가 섞여 있는 문자열을 받아 작은 수부터 차례로 정렬하여 출력하는 프로그램을 작성하라.

len(), chr(), ord()
'''
numbers = ['ZRO', 'ONE', 'TWO', 'THR', 'FOR', 'FIV', 'SIX', 'SVN', 'EGT', 'NIN']
def find_index(word):
    idx = -1
    for i in range(10):
        if word == numbers[i]:
            idx = i
            break
    return idx

tc = int(input())
for _ in range(1, tc+1):
    a, b = input().split()
    n = int(b)
    arr = list(input().split())

    count = [0] * 10
    for i in range(n):
        count[ find_index(arr[i]) ] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    res = [0] * n
    for i in range(n-1, -1, -1):
        res[count[ find_index(arr[i]) ] - 1] = arr[i]
        count[ find_index(arr[i]) ] -= 1

    print(f'{a}\n' + ' '.join(res))