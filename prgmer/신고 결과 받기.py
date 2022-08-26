from collections import OrderedDict

def solution_answer(id_list, report, k):
    answer = [0] * len(id_list) 
    reports = {x : 0 for x in id_list}

    for r in set(report):
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer

def solution(id_list, report, k):
    answer_dict1 = OrderedDict()
    answer_dict2 = OrderedDict()
    
    stop_member = []

    report = list(set(report))
    answer = []
    for id in id_list:
        answer_dict1[id] = 0
        answer_dict2[id] = []

    for r in report:
        name = r.split() 
        cnt = answer_dict1[name[1]]
        answer_dict1[name[1]] = cnt + 1

        if answer_dict1[name[1]] <= k:
            stop_member.append(name[1])
    
    for r in report:
        name = r.split() 
        answer_dict2[name[0]].append(name[1])

    for key in answer_dict2: 
        mail_cnt = 0
        for member in stop_member:
            if member in answer_dict2[key]:
                mail_cnt += 1

        answer.append(mail_cnt)

    return answer

if __name__ == '__main__':
    print(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2))
    print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 2))