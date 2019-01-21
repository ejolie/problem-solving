'''
4837. 부분집합의 합

1부터 12까지의 숫자를 원소로 가진 집합 A가 있다. 
집합 A의 부분 집합 중 N개의 원소를 갖고 있고, 
원소의 합이 K인 부분집합의 개수를 출력하는 프로그램을 작성하시오.

1 2 3 4 5 6 7 8 9 10 11 12
'''
def find_subset(n, k):
    arr = [i for i in range(1, 13)]
    cnt = 0
    for i in range(1, 1 << 12):  # 전체 부분집합 경우의 수
        temp = []
        for j in range(n):      # 각 원소가 포함되는지 확인
            if i & (1 << j):
                temp.append(arr[j])
        if sum(temp) == k:
            cnt += 1
    return cnt

tc = int(input())
for t in range(1, tc+1):
    n, k = map(int, input().split())
    result = find_subset(n, k)
    print(f'#{t} {result}')