import copy
import itertools

N, M, K = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
save_y_x = []
numbers = list(range(K))
permutations = list(itertools.permutations(numbers))

for _ in range(K):
    r, c, s = map(int, input().split())
    sty, stx = r - s - 1, c - s - 1
    edy, edx = r + s - 1, c + s - 1
    save_y_x.append([sty, stx, edy, edx])

def rotation(arr, y_x_arr):
    sty, stx, edy, edx = y_x_arr
    while sty < edy and stx < edx:
        prev_value = arr[sty][stx]
        for i in range(stx + 1, edx + 1):
            arr[sty][i], prev_value = prev_value, arr[sty][i]
        for i in range(sty + 1, edy + 1):
            arr[i][edx], prev_value = prev_value, arr[i][edx]
        for i in range(edx - 1, stx - 1, -1):
            arr[edy][i], prev_value = prev_value, arr[edy][i]
        for i in range(edy - 1, sty - 1, -1):
            arr[i][stx], prev_value = prev_value, arr[i][stx]
        sty += 1
        stx += 1
        edy -= 1
        edx -= 1

def getMin(arr):
    return min(sum(row) for row in arr)

Min = float('inf')
for perm in permutations:
    arr = copy.deepcopy(lst)
    for idx in perm:
        rotation(arr, save_y_x[idx])
    Min = min(Min, getMin(arr))

print(Min)
