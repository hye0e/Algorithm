from collections import deque, defaultdict


def solution(tickets):
    answer = []
    # tickets.sort(key = lambda x: (x[1], x[0]))
    dic = defaultdict(list)
    for [start, end] in tickets:
        dic[start].append(end)

    for key in dic.keys():
        dic[key].sort(reverse = True)
    print(dic)
    def dfs():
        stack = ['ICN']
        while stack:
            start = stack[-1]
            if not dic[start]:
                answer.append(stack.pop())
            else:
                # 항공편이 존재하면
                stack.append(dic[start].pop())
    dfs()
    return answer[::-1]

print(solution([["ICN", "A"], ["A", "B"], ["A", "C"], ["C", "A"], ["B", "D"]]))
# print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]))
# ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
# print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))