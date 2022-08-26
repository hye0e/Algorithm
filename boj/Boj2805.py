def binary_search(tree_list, low, high, goal):
    result = 0
    while low <= high:
        total = 0
        mid = (low + high) // 2
        for tree in tree_list:
            if tree > mid:
                total += tree - mid

        if total < goal:
            high = mid - 1
        else:
            result = mid
            low = mid + 1
    return result

N, M = map(int, input().split())
tree_list = list(map(int, input().split()))

low = 0
high = max(tree_list) 
print(binary_search(sorted(tree_list), low, high, M))