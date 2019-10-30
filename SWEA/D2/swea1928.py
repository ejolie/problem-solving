'''
swea1928. Base64 Decoder (D2)

8 bit, 8 bit, 8 bit
6 bit, 6 bit, 6 bit, 6bit (0 ~ 63)
'''
tc = int(input())
for t in range(1, tc+1):
    s = input()
    # TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u
    # 84 71 108
    # 1010100 1000111 1101100
    # 101010 010001 111101 100
    # 42 17 61
    # Life itself is a quotation.