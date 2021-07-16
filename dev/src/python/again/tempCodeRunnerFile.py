    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2] + 1)