from typing import List

def make(num):
    size = 0
    n = 0
    while num > size:
        size = 2 ** n
        n += 1

    return size
def solution(queries: List[List[int]]) -> int:    
    answer = 0
    copy = 0
    # 배열 번호와 남은 크기
    dict = {}
    for query in queries:
        if query[0] not in dict:
            size = make(query[1])
            rest_size = size - query[1]
            dict[query[0]] = [rest_size, [query[1]]]
        else:
            # 추가를 하지 않아도 될 경우
            if dict[query[0]][0] >= query[1]:
                dict[query[0]][0] = dict[query[0]][0] - query[1]
                dict[query[0]][1].append(query[1])
            # 추가를 해줘야할 경우 1. 추가 2. 복사
            else:
                size = make(sum(dict[query[0]][1]) + query[1])
                copy += sum(dict[query[0]][1])

                dict[query[0]][0] = size - query[1]
                dict[query[0]][1].append(query[1])

    return copy

if __name__ == '__main__':
    solution([[2, 10], [7, 1], [2, 5], [2, 9], [7, 32]])