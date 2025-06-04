def solution(arr):
    stk = []
    i = 0

    while i < len(arr):
        # 1. stk가 비었으면 arr[i]를 추가
        if not stk:
            stk.append(arr[i])
            i += 1
        # 2. stk 마지막 원소와 arr[i]가 같으면 stk 마지막 제거
        elif stk[-1] == arr[i]:
            stk.pop()
            i += 1
        # 3. 다르면 arr[i]를 stk에 추가
        else:
            stk.append(arr[i])
            i += 1

    # 조건에 따라 빈 배열이면 [-1] 반환
    return stk if stk else [-1]
