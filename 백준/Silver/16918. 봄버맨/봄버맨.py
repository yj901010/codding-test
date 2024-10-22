R, C, N = map(int, input().split())
lst = [list(input()) for _ in range(R)]  # 초기 상태 저장
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # 상하좌우 방향

# 폭탄이 터진 후의 상태를 만드는 함수
def detonate(board):
    new_board = [['O'] * C for _ in range(R)]  # 전체를 폭탄으로 채움
    for y in range(R):
        for x in range(C):
            if board[y][x] == 'O':  # 폭탄이 있던 자리
                new_board[y][x] = '.'  # 자기 자신
                for dy, dx in dir:  # 상하좌우 폭발
                    ny, nx = y + dy, x + dx
                    if 0 <= ny < R and 0 <= nx < C:
                        new_board[ny][nx] = '.'
    return new_board

# N이 1일 경우: 초기 상태 그대로 출력
if N == 1:
    for row in lst:
        print(''.join(row))

# N이 짝수일 경우: 전체가 폭탄으로 채워진 상태 출력
elif N % 2 == 0:
    for _ in range(R):
        print('O' * C)

# N이 3, 7, 11, ... 일 경우: 초기 폭탄이 터진 상태 출력
elif N % 4 == 3:
    result = detonate(lst)  # 초기 상태에서 폭탄이 터진 결과
    for row in result:
        print(''.join(row))

# N이 5, 9, 13, ... 일 경우: 3초 후의 상태가 반복됨
elif N % 4 == 1:
    first_detonation = detonate(lst)  # 초기 폭탄 터진 상태
    result = detonate(first_detonation)  # 두 번째 폭발 결과
    for row in result:
        print(''.join(row))
