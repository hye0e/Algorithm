def binary_search(low, high, n_list, key):
    while low <= high:
        mid = (low + high) // 2
        if n_list[mid] == key:
            return mid
        elif key < n_list[mid]:
            high = mid - 1
        else:
            low = mid + 1

    return None


N = int(input())
n_list = list(map(int, input().split()))
M = int(input())
m_list = list(map(int, input().split()))

low = 0
high = len(n_list) - 1

for i in m_list:
    result = binary_search(low, high, sorted(n_list), i)
    if result != None:
        print(1)
    else:
        print()
    
