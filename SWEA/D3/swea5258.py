'''
swea5258. 해피박스 (D3)

- 박스에 담긴 물건의 가격 합이 최대가 되도록
- 남은 물건의 크기와 가격이 주어질 때,
담을 수 있는 물건의 최대 가격
'''
tc = int(input())
for t in range(1, tc+1):
	N, M = map(int, input().split()) # 박스 크기, 상품 개수
	size = [0] * M
	price = [0] * M
	for i in range(M):
		size[i], price[i] = map(int, input().split())