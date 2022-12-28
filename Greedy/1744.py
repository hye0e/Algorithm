import sys

input = sys.stdin.readline

N = int(input().strip())

negative_arr = []
zero_arr = []
positive_arr = []

for i in range(N):
    num = int(input().strip())
    if num < 0:
        negative_arr.append(num)
    elif num == 0:
        zero_arr.append(num)
    else:
        positive_arr.append(num)

positive_arr.sort()
negative_arr.sort(reverse = True)

answer = 0

while negative_arr:
    max_num = 0
    num = negative_arr.pop()
    another_index = -1

    zero_flag = False
    for i in range(len(negative_arr)):
        if num * negative_arr[i] > num + negative_arr[i]:
            another_index = i
            max_num = num * negative_arr[another_index]
        else:
            max_num = num
            another_index = -1

    # 음수 상쇄
    for i in range(len(zero_arr)):
        if max_num <= num * 0:
            zero_flag = True

    if zero_flag:
        answer += 0
        zero_arr.pop()
    # 묶이지 않는 경우
    elif another_index == -1:
        answer += num
    else:
        answer += max_num
        negative_arr.pop(another_index)

while positive_arr:
    num = positive_arr.pop()
    another_index = -1
    max_num = 0

    for i in range(len(positive_arr)):
        if positive_arr[i] + num < positive_arr[i] * num:
            another_index = i
            max_num = positive_arr[i] * num
        else:
            another_index = i
            max_num = positive_arr[i] + num

    if another_index != -1:
        answer += max_num
        positive_arr.pop(i)
    else:
        answer += num

print(answer)