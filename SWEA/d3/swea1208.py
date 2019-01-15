'''
1208. Flatten

가로 길이는 항상 100으로 주어진다.
모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.
덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 
그 때의 최고점과 최저점의 높이 차를 반환한다.
(주어진 data에 따라 0 또는 1이 된다)
'''
def flatten(times, heights):
    cnt = 0
    while cnt <= times:
        maxHeight = max(heights)
        minHeight = min(heights)
        diff = maxHeight - minHeight
        if diff <= 1:
            break
        maxIdx = heights.index(maxHeight)
        minIdx = heights.index(minHeight)
        heights[maxIdx] -= 1
        heights[minIdx] += 1
        cnt += 1
    return diff

for t in range(1, 11):
    times = int(input())
    heights = [int(i) for i in input().split()]
    result = flatten(times, heights)
    print(f'#{t} {result}')