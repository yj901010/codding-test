T = int(input())

for tc in range(1,T+1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    def catchFly(y,x):
        global N,M,arr
        directY = [-1,1,0,0,-1,-1,1,1]
        directX = [0,0,-1,1,-1,1,-1,1]
        p_sum = 0
        x_sum = 0
        for i in range(4):
            for power in range(1,M):
                dpy = y+directY[i] * power
                dpx = x+directX[i] * power

                dcy = y+directY[4+i] * power
                dcx = x+directX[4+i] * power

                if 0 <= dpy < N and 0 <= dpx < N:
                    p_sum += arr[dpy][dpx]
                if 0 <= dcy < N and 0 <= dcx < N:
                    x_sum += arr[dcy][dcx]
        return max(p_sum,x_sum)+arr[y][x]

    Max = 0
    for i in range(N):
        for j in range(N):
            val = catchFly(i,j)
            if Max < val:
                Max = val

    print(f'#{tc} {Max}')