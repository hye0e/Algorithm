#-*- coding:utf-8 -*-
# 1. visited 방문하면 True
# 2. 이미 방문한 곳이면 탈출
# 3. result 더해주기
import sys
sys.setrecursionlimit(2000)

def dfs(num):
    visited[num] = True
    val = num_list[num]
    if not visited[val]:
        dfs(val)

N = int(sys.stdin.readline())
for _ in range(N):
    index = int(sys.stdin.readline())
    result = 0

    visited = [True] + [False] * index
    num_list = [0] + list(map(int, sys.stdin.readline().split()))

    for i in range(1, index + 1):
        if not visited[i]:
            dfs(i)
            result += 1
    print(result)   
