def solution(L, target):
    idx = 0
    cut_idx = len(L) // 2
    if ((len(L) == 0) or (L[0] > target) or (L[-1] < target))==True:
        return -1
    elif L[cut_idx] < target:
        idx += cut_idx
        return solution(L[cut_idx:], target)
    elif L[cut_idx] > target:
        return solution(L[:cut_idx], target)
    elif L[cut_idx] == target:
        idx += cut_idx
        return idx


if __name__ == '__main__':
    print(solution([20, 37, 58, 72, 91, 99], 99))
    