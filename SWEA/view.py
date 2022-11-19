T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    answer = 0
    N = int(input())
    num = list(map(int, input().strip().split()))
    print(len(num))
    for i in range(2, len(num) - 2):
        flag = True
        cnt = 0
        for j in (i - 2, i - 1, i + 1, i + 2):
            # 조망권 침해
            cnt = max(cnt, num[j])
            if num[i] < num[j]:
                flag = False

        if flag:
            answer += num[i] - cnt

    print('#{} {}'.format(test_case, answer))

