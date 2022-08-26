import sys

input = sys.stdin.readline

N, C = input()
arr = []
for i in range(N):
    arr.append(int(input()))

left = 0
right = max(arr)

def count(len):
    dis = 0
    if len 
