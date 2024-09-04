import sys
sys.setrecursionlimit(10**6)
def dfs(y,x):
    diry=[-1,1,0,0,-1,-1,1,1]
    dirx=[0,0,-1,1,-1,1,-1,1]
    for i in range(8):
        dy = y+diry[i]
        dx = x+dirx[i]
        if not (0<=dy<h and 0<=dx<w): continue
        if arr[dy][dx] == 0: continue
        if visited[dy][dx]: continue
        visited[dy][dx] = 1
        dfs(dy,dx)
    return 1

while 1:
    w,h = map(int,input().split())
    if w==0 and h==0:
        break
    arr = [list(map(int,input().split())) for _ in range(h)]
    visited = [[0]*w for _ in range(h)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j]:
                if visited[i][j]==0:
                    visited[i][j] = 1
                    cnt += dfs(i,j)
    print(cnt)