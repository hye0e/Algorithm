n = int(input())
wine_list = [int(input()) for x in range(n)]

dp = [0]
dp.append(wine_list[0])
if(n > 1):
    dp.append(wine_list[0] + wine_list[1])

for i in range(3, n + 1):
    case_1 = wine_list[i - 1] + dp[i - 2]
    case_2 = wine_list[i - 1] + wine_list[i - 2] + dp[i - 3]
    case_3 = dp[i - 1]
    max_value = max(case_1, case_2, case_3)
    
    dp.append(max_value)
    
print(dp[n])