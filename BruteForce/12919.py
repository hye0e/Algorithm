"""
9시30분까지
"""
import sys

input = sys.stdin.readline

S = input().strip()
T = input().strip()

# T가 무조건 더 기니까
def dfs(T):
    if S == T:
        print(1)
        exit()

    if len(T) == 0:
        return 0

    if T[-1] == 'A':
        dfs(T[:-1])
    if T[0] == 'B':
        dfs(T[1:][::-1])

dfs(T)
print(0)