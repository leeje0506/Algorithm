def solution(s1, s2):
    cnt = 0
    #s1하나씩 빼서 item = "a" 이런 식으로 넣는 거임. 배열 값의 갯수만큼 그걸 하는 거.
    #그 다음 s2안에 item이 포함되어 있는지 확인하는 것. 
    #즉, item = "a"일 때, s2 = ["a", "b", "c"] 중에 "a"가 있는가를 찾는다. (true 라면 cnt +=1)
    for item in s1:
        if item in s2:
            cnt +=1
    return cnt