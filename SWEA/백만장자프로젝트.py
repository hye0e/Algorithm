T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    # 그리디: 최저가에 사서 최대값에 파는 것
    cost = list(map(int, input().split()))
    answer = 0
    for i in range(N):
        sum = 0
        right = i + 1
        while right < N:
            if sum <= cost[right] - cost[i]:
                sum = cost[right] - cost[i]

            # 초기화
            right += 1

        answer += sum

    print('#{} {}'.format(test_case, answer))
