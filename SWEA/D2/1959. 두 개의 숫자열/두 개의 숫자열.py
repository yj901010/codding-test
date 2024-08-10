T = int(input())

for tc in range(1,T+1):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))

    l, d = 0,0 # l은 N,M의 최소 길이, d는 l,d의 길이 차이
    if N > M:
        l = M
        d = N-M
    else:
        l = N
        d = M-N

    Max = 0

    for i in range(d+1):
        Sum = 0
        for j in range(l):
            if l == M:
                Sum = Sum + A[i+j] * B[j]
            else:
                Sum = Sum + A[j] * B[i+j]
        if Sum > Max:
            Max = Sum

    print(f'#{tc} {Max}')