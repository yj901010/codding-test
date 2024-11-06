board = input()

result = ''
i = 0
n = len(board)

while i < n:
    if board[i] == 'X':
        count = 0
        # 'X'의 연속된 길이를 계산
        while i < n and board[i] == 'X':
            count += 1
            i += 1
        
        # 길이에 따라 'AAAA'와 'BB'로 변환
        if count % 2 != 0:
            result = -1
            break
        else:
            result += 'AAAA' * (count // 4)
            if count % 4 == 2:
                result += 'BB'
    else:
        # '.'일 경우 그대로 추가
        result += board[i]
        i += 1

print(result)
