import sys

input = sys.stdin.readline

N = int(input().strip())
def get_prime_num(N):
    i = 2

    visited = [False for i in range(N + 1)]
    prime_num = []
    while i*2 <= N:
        for j in range(i*2, N+1, i):
            if not visited[j]:
                visited[j] = True

        i += 1

    for i in range(2, N + 1):
        if not visited[i]:
            prime_num.append(i)

    return prime_num

start, end = 0, 0
answer = 0
internal_sum = 0
prime_num = get_prime_num(N)

for start in range(len(prime_num)):
    while internal_sum < N and end < len(prime_num):
        internal_sum += prime_num[end]
        end += 1

    if internal_sum == N:
        answer += 1

    internal_sum -= prime_num[start]

print(answer)
