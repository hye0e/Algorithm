# 첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.
import sys

input = sys.stdin.readline

N = int(input())

def get_prime_num(N):
    start = 2
    visited = [False for _ in range(N + 1)]
    prime_num = []
    while start*2 <= N:
        for i in range(start*2, N + 1, start):
            if not visited[i]:
                visited[i] = True

        start += 1

    for i in range(2, len(visited)):
        if not visited[i]:
            prime_num.append(i)

    return prime_num

prime_num = get_prime_num(N)

start, end = 0, 0
internal_sum = 0
answer = 0
for start in range(len(prime_num)):
    while internal_sum < N and end < len(prime_num):
        internal_sum += prime_num[end]
        end += 1

    if internal_sum == N:
        answer += 1

    internal_sum -= prime_num[start]

print(answer)


