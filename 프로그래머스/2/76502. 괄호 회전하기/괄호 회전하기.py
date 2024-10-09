from collections import deque
def solution(s):
    answer = 0
    l = len(s)
    d = deque(s)
    result = set()
    for _ in range(l):
        d.rotate(-1)
        result.add(''.join(d))

    for val in result:
        stack = []
        flag = 1
        for c in val:
            if not stack and c in ['[','{','(']:
                stack.append(c)
            elif stack and c in [')','}',']']:
                if stack[-1] == '(' and c ==')':
                    stack.pop()
                elif stack[-1] == '[' and c ==']':
                    stack.pop()
                elif stack[-1] == '{' and c =='}':
                    stack.pop()
                else:
                    flag = 0
                    break
            elif stack and c in ['[','{','(']:
                stack.append(c)
            else:
                flag = 0
                break
        if flag and not stack:
            answer += 1

    return answer