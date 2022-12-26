import sys

input = sys.stdin.readline().strip()
input_arr = []
num = ''
index = 0
temp = input

while len(input) != 0:
    if input[0] == '-' or input[0] == '+':
        input_arr.append(int(num))
        num = ''
        input_arr.append(input[0])
    else:
        num += input[0]
    index += 1
    input = temp[index:]

    # 마지막
    if len(input) == 0:
        input_arr.append(int(num))

minus_flag = False
for i in range(len(input_arr)):
    if input_arr[i] == '-':
        minus_flag = True

    if minus_flag and (input_arr[i] != '+' and input_arr[i] != '-'):
        input_arr[i] = (-1) * input_arr[i]

answer = 0
for i in input_arr:
    if i != '+' and i != '-':
        answer += i

print(answer)