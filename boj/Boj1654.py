K, N = map(int, input().split())
lan_list = [int(input()) for x in range(K)]

low = 0
high = max(lan_list)

result = 0
while low <= high:
    total = 0
    mid = (low + high) // 2

    for lan in lan_list:
        total += lan // mid

    if total < N:
        high = mid - 1
    else:
        result = mid
        low = mid + 1

print(result)