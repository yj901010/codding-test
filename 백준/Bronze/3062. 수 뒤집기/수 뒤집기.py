T = int(input())
for tc in range(T):
    n = int(input())
    sn = str(n)
    sn = sn[::-1]
    sn = int(sn)
    Sum = n+sn
    sSum = str(Sum)
    if sSum == sSum[::-1]:
        print('YES')
    else:
        print('NO')