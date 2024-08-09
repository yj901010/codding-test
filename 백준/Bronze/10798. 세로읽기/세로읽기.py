arr = [list(map(str,input())) for _ in range(5)]
row_len = [len(row) for row in arr]
Max = max(row_len)

for i in range(Max):
    for j in range(5):
        if len(arr[j])-1 < i:
            pass
        else:
            print(arr[j][i],end='')