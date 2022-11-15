from collections import deque

T = int(input())

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 입력
    chase = []
    flag = 'yes'
    for i in range(8):
        chase.append(list(input()))

    # 확인
    cnt = 0
    queue = deque()
    for x in range(8):
        for y in range(8):
            if cnt > 8:
                break
            if chase[x][y] == 'O':
                cnt += 1
                queue.append([x, y])

    if cnt != 8:
        flag = 'no'
    else:
        while queue:
            x, y = queue.pop()
            for i in range(8):
                if chase[i][y] == 'O' and x != i:
                    flag = 'no'

            for i in range(8):
                if chase[x][i] == 'O' and y != i:
                    flag = 'no'

    print("#{} {}".format(test_case, flag))