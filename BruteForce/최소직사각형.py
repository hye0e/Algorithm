def solution(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)

def solution_mine(sizes):
    for index in range(len(sizes)):
        if sizes[index][0] > sizes[index][1]:
            sizes[index][0], sizes[index][1] = sizes[index][1], sizes[index][0]

    max_x = 0
    max_y = 0
    for x, y in sizes:
        if max_x < x:
            max_x = x
        if max_y < y:
            max_y = y

    for x in sizes:
        print(x)

    return max_x * max_y

if __name__ == '__main__':
    print(solution_mine([[60, 50], [30, 70], [60, 30], [80, 40]]))
    # print(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]))
