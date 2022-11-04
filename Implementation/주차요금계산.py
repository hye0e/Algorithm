# 시간 계산
import math

# 누적 시간 계산
def cal_time(in_time, out_time):

    in_time = list(map(int, in_time.split(':')))  # [22, 59]
    out_time = list(map(int, out_time.split(':')))  # [23, 59]

    # 시가 더 클 경우
    if out_time[0] > in_time[0]:
        out_time[0] -= 1
        out_time[1] += 60

    return abs(in_time[0] - out_time[0]) * 60 + abs(in_time[1] - out_time[1])

def solution(fees, records):
    answer = []
    in_dict = {}
    out_dict = {}
    # dict 형태로 정리
    for record in records:
        time, car, in_out = record.split()
        if in_out == 'IN':
            if car not in in_dict:
                in_dict[car] = [time]
            else:
                in_dict[car].append(time)
        elif in_out == 'OUT':
            if car not in out_dict:
                out_dict[car] = [time]
            else:
                out_dict[car].append(time)

    for key in in_dict:
        if key not in out_dict:
            out_dict[key] = ['23:59']

        while len(in_dict[key]) != len(out_dict[key]):
            out_dict[key].append('23:59')

    sort_dict = sorted(in_dict)
    for key in sort_dict:
        time = 0  # 누적 주차 시간

        while in_dict[key] and out_dict[key]:
            in_time = in_dict[key].pop()
            out_time = out_dict[key].pop()

            time += cal_time(in_time, out_time)

        if time <= fees[0]:
            answer.append(fees[1])  # 기본요금
        elif time > fees[0]:
            fee = fees[1] + math.ceil(((time - fees[0]) / fees[2])) * fees[3]
            answer.append(fee)

    return answer

print(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))