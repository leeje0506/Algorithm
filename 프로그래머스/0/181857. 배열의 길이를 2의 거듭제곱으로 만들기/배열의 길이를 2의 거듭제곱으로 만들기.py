import math

def solution(arr):
    length = len(arr)
    
    # 길이가 이미 2의 제곱이면 그대로 반환
    if (length & (length - 1)) == 0:
        return arr

    # 다음 2의 제곱 길이를 구하고 0을 추가
    next_power = 2 ** math.ceil(math.log2(length))
    return arr + [0] * (next_power - length)
