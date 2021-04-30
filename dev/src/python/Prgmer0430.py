from collections import Counter
def solution(n, lost, reserve):
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)
    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)

    print(set_lost)
    print(set_reserve)
    return n-len(set_lost)

if __name__ == '__main__':
    solution(5, [2, 4], [1, 3, 5])