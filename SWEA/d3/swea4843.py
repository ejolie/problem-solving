'''
4843. 특별한 정렬 

N개의 정수가 주어지면 가장 큰 수, 가장 작은 수, 
2번째 큰 수, 2번째 작은 수 식으로 큰 수와 작은 수를 번갈아 정렬한다.
주어진 숫자에 대해 특별한 정렬을 한 결과를 10개까지 출력하시오.
'''
tc = int(input())
for t in range(1, tc+1):
    n = int(input())
    arr = sorted([int(i) for i in input().split()])

    result = [0] * 10
    for i in range(0, 10):
        if i % 2 == 0:
            result[i] = str(arr.pop())
        else:
            result[i] = str(arr.pop(0))
    s = ' '.join(result)
    print(f'#{t} {s}')