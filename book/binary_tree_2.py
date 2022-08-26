import sys

def binary(search, key):
    low = 0
    high = len(search) - 1
    while low <= high:
        mid = (low+high) // 2

        if key == search[mid]:
            return True
        elif key < search[mid]:
            high = mid - 1
        else:
            low = mid + 1
    
    return False

n = int(input())
n_list = list(map(int, sys.stdin.readline().rstrip().split()))
n_list.sort()

m = int(input())
m_list = list(map(int, sys.stdin.readline().rstrip().split()))

for i in range(len(m_list)):
    if binary(n_list, m_list[i]):
        print('yes', end = '')
    else:
        print('No', end = '')