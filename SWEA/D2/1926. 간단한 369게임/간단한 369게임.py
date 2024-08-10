N = int(input())

for i in range(1,N+1):
    s = str(i)
    check = s.count('3') + s.count('6') + s.count('9')
    if check:
        print('-'*check,end=' ')
    else:
        print(i,end=' ')