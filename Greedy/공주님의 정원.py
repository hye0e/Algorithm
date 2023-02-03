import sys
#4
# 1 1 7 8
# 7 8 9 10
# 7 8 10 10
# 10 10 12 10
input = sys.stdin.readline

N = int(input())

cal = []
for _ in range(N):
    start_month, start_day, end_month, end_day = map(int, input().strip().split())
    cal.append([start_month * 100 + start_day, end_month * 100 + end_day])

cal.sort(key=lambda x: x[0])

# 3/1일 이전은 301로 변경 12/1일 이후는 1201로 변경
cal_format = []
for i in range(N):
    table = []
    if cal[i][0] <= 301:
        table.append(301)
    else:
        table.append(cal[i][0])

    if cal[i][1] >= 1201:
        table.append(1201)
    else:
        table.append(cal[i][1])
    cal_format.append(table)

now_start = cal_format[0][0]
now_end = cal_format[0][1]
start_index = 0

plant = 1

# 가장 멀리가기
for i in range(1, N):
    if cal_format[i][0] != 301:
        break

    if now_start == 301:
        now_end = max(now_end, cal_format[i][1])
        start_index = i

print(cal_format)
temp_start = now_start
temp_end = now_end

count = 0

while True:
    if start_index >= N - 1:
        break

    for i in range(start_index + 1, N):
        if temp_end == 1201:
            break

        # 조건1) 하루라도 공백기가 생기면 안되니, 현재 심을 꽃이 now_end 보다 작아야함 ex) 현재 심을 꽃 502 <= 503 now_end
        # 조건2) 더 오래 심을 수 있어야지 최소의 꽃을 심을 수 있음
        # 조건3)
        if cal_format[i][0] <= now_end \
                and cal_format[i][1] >= now_end\
                and cal_format[i][0] >= temp_start\
                and cal_format[i][1] >= temp_end:
        # if cal_format[i][0] <= now_end and cal_format[i][1] > now_end:
            temp_start = cal_format[i][0]
            temp_end = cal_format[i][1]
            start_index = i

    if now_start != temp_start and now_end != temp_end:
        # 최종적으로 심음
        plant += 1
        now_start = temp_start
        now_end = temp_end
    else:
        start_index += 1

    # 더 볼 필요없음
    if now_end == 1201:
        break

if cal_format[0][0] == 301 and now_end == 1201:
    print(plant)
else:
    print(0)






