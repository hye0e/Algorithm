"""
N과 M (1)
자연수 N과 M이 주어졌을 때,
아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
"""
import sys

input = sys.stdin.readline

N, M = map(int,input().strip().split())
print(N, M)
arr = []
visited = [False for i in range(N + 1)]
print_arr = []
def dfs(depth):
    if depth == M:
        print(print_arr)
        return

    for i in range(1, N + 1):
        if visited[i]:
            continue
        arr.append(i)
        dfs(i, depth + 1, visited)
        arr.pop()
        visited[i] = False


dfs()
