"""
121
1231
12421
0
"""
import sys

input = sys.stdin.readline

while True:
    num = input().strip()

    if num == '0':
        break
    
    if num == num[::-1]:
        print('yes')
    else:
        print('no')

