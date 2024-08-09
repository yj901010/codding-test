def findBingo(user, val, check):
    for row in range(5):
        if val in user[row]:
            col = user[row].index(val)
            check[row][col] = 1

def bingoCheck(check):
    b_cnt = 0

    # 행 검사
    for row in check:
        if row.count(1) == 5:
            b_cnt += 1

    # 열 검사
    col_arr = list(map(list, zip(*check)))
    for col in col_arr:
        if col.count(1) == 5:
            b_cnt += 1

    # 대각선 검사
    r_c = l_c = 0
    for c in range(5):
        r_c += check[c][c]
        l_c += check[c][4-c]
    if r_c == 5:
        b_cnt += 1
    if l_c == 5:
        b_cnt += 1

    return b_cnt

# 입력 받기
user = [list(map(str, input().split())) for _ in range(5)]
com = [list(map(str, input().split())) for _ in range(5)]
check = [[0] * 5 for _ in range(5)]

cnt = 0
flag = False

# 호출 처리
for i in range(5):
    for j in range(5):
        findBingo(user, com[i][j], check)
        cnt += 1
        if bingoCheck(check) >= 3:
            flag = True
            break
    if flag:
        break

print(cnt)
