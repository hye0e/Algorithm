import sys

def binary(search, key, start, end):
    while start <= end:
        mid = (start + end) // 2

        if search[mid] == key:
            return True
        elif key < search[mid]:
            end = mid - 1
        else:
            start = mid + 1

    return False

def validation(k, mid):
    return k <= mid


input_list = list(map(int, sys.stdin.readline().rstrip().split()))
input_data = list(map(int, sys.stdin.readline().rstrip().split()))
input_data.sort()
