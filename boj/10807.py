import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
V = int(input())

print(arr.count(V))