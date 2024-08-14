T = int(input())

for tc in range(1,T+1):
    # n양 받기
    n = int(input())
    # 0-9까지 확인용 리스트
    lst = [0] * 10
    # n양 배수용
    cnt = 0
    # lst에 0이 있을 때
    while 0 in lst:
        cnt += 1
        # n_lst = n*cnt을 자릿수 별로 뜯어서 정수로 저장
        n_lst = [int(item) for item in str(n*cnt)]
        '''
        n_lst = []
        for item in str(n*cnt):
            n_lst.append(int(item))
        '''
        # 뜯은 정수를 돌면서
        for k in n_lst:
            # lst 내에서 뜯은 정수가 체크 됐는지 확인
            if lst[k] == 0:
                lst[k] = 1
        # 배수 값 +1
        
    print(f'#{tc} {n*(cnt)}')