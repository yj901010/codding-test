def solution(n, left, right):
    answer = []

    for i in range(right-left+1):
        row = (left+i)//n
        col = (left+i)%n
        answer.append(max(row,col)+1)

    return answer