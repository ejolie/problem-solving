'''
4835. 구간합

N개의 정수가 들어있는 배열에서 이웃한 M개의 합을 계산하는 것은 디지털 필터링의 기초연산이다.
M개의 합이 가장 큰 경우와 가장 작은 경우의 차이를 출력하는 프로그램을 작성하시오.
'''
tc = int(input())
for t in range(1, tc+1):
    n, m = map(int, input().split())
    nums = [int(i) for i in input().split()]

    minSum = sum(nums[0:m])
    maxSum = sum(nums[0:m])

    for i in range(1,n-m+1):
        cmp = sum(nums[i:i+m])
        if cmp < minSum:
            minSum = cmp
        elif cmp > maxSum:
            maxSum = cmp

    print(f'#{t} {maxSum-minSum}')