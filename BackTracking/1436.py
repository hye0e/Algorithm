import sys

N = int(input())
num_six = 666
cnt = 0
while True:
    if '666' in str(num_six):
        cnt += 1

    if cnt == N:
        print(num_six)
        break

    num_six += 1
