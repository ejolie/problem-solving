'''
swea1240. 단순 2진 암호코드 (D3)

암호코드 하나 : 8자리 숫자
- 앞 7자리 : 상품 고유 번호
- 마지막 자리 : 검증 코드
검증 코드 : (홀수 자리의 합 x 3) + 짝수 자리의 합 + 검증 코드 % 10 == 0

세로 50 가로 100 이하의 크기를 가진 직사각형 배열에 암호코드 정보
암호코드에 구성하는 숫자 하나가 차지하는 길이는 7칸

암호코드 정보가 포함된 2차원 배열을 입력으로 받아 정상적인 암호코드를 판별하는 프로그램
'''
def num(word):
    key = ['0001101', '0011001', '0010011', '0111101', '0100011',\
        '0110001', '0101111', '0111011', '0110111', '0001011']
    for i in range(10):
        if key[i] == word:
            return i

def check(nums): # nums: 8자리, 0~7
    ans, odd, even = 0, 0, 0
    for i in range(7):
        if not i & 1:
            odd += nums[i]
        else:
            even += nums[i]
    ans = odd * 3 + even + nums[7]
    if not ans % 10:
        return sum(nums)
    else:
        return 0

for t in range(1, int(input())+1):
    H, W = map(int, input().split())
    arr = [0] * H
    sx, sy = -1, -1
    fx, fy = -1, -1
    for i in range(H):
        arr[i] = list(input())
        if (fx, fy) == (-1, -1):
            for j in range(-1, -W-1, -1):
                 if arr[i][j] == '1':
                    fx, fy = i, W+j
                    sx, sy = i, fy-55
                    break
    nums = []
    for j in range(8):
        word = arr[sx][sy+j*7:sy+(j+1)*7]
        nums.append(num(''.join(word)))
    print('#{} {}'.format(t, check(nums)))