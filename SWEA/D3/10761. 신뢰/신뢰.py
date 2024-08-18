T = int(input())
for tc in range(1, T + 1):
    input_s = input().split()

    pos_b = pos_o = 1  
    total = 0  
    opposite_time = 0    
    pre_robot = input_s[1] 
    for i in range(1, len(input_s), 2):
        robot = input_s[i]  
        pos = int(input_s[i + 1])

        if robot == 'B':    
            time = abs(pos - pos_b) 
            pos_b = pos
        else:
            time = abs(pos - pos_o)
            pos_o = pos

        if pre_robot == robot:
            total += time + 1
            opposite_time += time + 1
        else:
            if opposite_time - time > 0:
                time = 1
            else:
                time = time - opposite_time + 1
            total += time
            opposite_time = time
            pre_robot = robot

    print(f'#{tc} {total}')