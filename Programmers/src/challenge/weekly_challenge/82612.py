"""
1주차. 부족한 금액 계산하기
"""


def solution(price, money, count):
    play = 1
    while play <= count:
        money -= price * play
        play += 1
    return 0 if money > 0 else money * -1
