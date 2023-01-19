T = int(input().strip())

for i in range(T):
    N = int(input().strip())
    dp = [[0 for _ in range(N)] for _ in range(2)]

    stiker = [list(map(int, input().split())) for _ in range(2)]

    # 2번째까지는 답정너

    dp[0][0] = stiker[0][0]
    dp[1][0] = stiker[1][0]

    # N(1 ≤ n ≤ 100,000) 이기 때문에 잡아주지 않으면 IndexError
    if N > 1:
        dp[0][1] = dp[1][0] + stiker[0][1]
        dp[1][1] = dp[0][0] + stiker[1][1]

    for j in range(2, N):
        dp[0][j] = stiker[0][j] + max(dp[1][j - 1], dp[1][j - 2])
        dp[1][j] = stiker[1][j] + max(dp[0][j - 1], dp[0][j - 2])
    print(max(dp[0][N - 1], dp[1][N - 1]))