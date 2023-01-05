"""
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다.
(1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
주어지는 정수의 절댓값은 100,000을 넘지 않는다.

8:30까지
"""
N, S = map(int, input().split())
arr = []
ans = 0
visited = [False for i in range(N)]
num = list(map(int, input().split()))

def dfs(index):
    global ans
    if sum(arr) == S and len(arr) > 0:
        print(arr)
        ans += 1

    for i in range(index + 1, len(num)):
        arr.append(num[i])
        dfs(i)
        arr.pop()

dfs(-1)
print(ans)

