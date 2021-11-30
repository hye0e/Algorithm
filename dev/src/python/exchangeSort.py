def exchangeSort(arr):
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] < arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
        print(arr)
        
if __name__ == '__main__':
    exchangeSort([3, 1, 2, 4, 6, 5])