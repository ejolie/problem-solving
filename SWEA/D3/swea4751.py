'''
swea4751. 다솔이의 다이아몬드 장식 (D3)

..#...#...#...#...#..
.#.#.#.#.#.#.#.#.#.#.
#.A.#.P.#.P.#.L.#.E.#
.#.#.#.#.#.#.#.#.#.#.
..#...#...#...#...#..

글자수  행수
1      2*2 + 1 (4*1 + 1)
5     2*10 + 1 (4*5 + 1) index: 0 ~ 20
6              (4*6 + 1)
'''
tc = int(input())
for t in range(1, tc+1):
	word = input(); N = len(word)
	arr = [[''] for _ in range(5)]
	arr[0] = arr[4] = '..#..' + '.#..'*(N-1)
	arr[1] = arr[3] = '.' + '#.#.'*N
	arr[2] = '#.' + '.#.'.join(word) +'.#'
	for a in arr:
		print(a)

