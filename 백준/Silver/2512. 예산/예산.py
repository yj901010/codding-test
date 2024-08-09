def budget():
    low, high = 0, max(request)
    
    while low <= high:
        mid = (low + high) // 2
        crt_sum = sum(min(req, mid) for req in request)
        
        if crt_sum > M:
            high = mid - 1
        else:
            low = mid + 1

    print(high)

N = int(input())
request = list(map(int, input().split()))
M = int(input())

budget()
