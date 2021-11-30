def cocktailShakerSort(arr):
    maxFlag = True
    swapFlag = True
    right = len(arr) - 1
    left = 0
    
    while swapFlag:
        swapFlag = False

        if maxFlag:
            for i in range(left, right):
                if arr[i] > arr[i + 1]:
                    arr[i], arr[i + 1] = arr[i + 1], arr[i]
                    swapFlag = True

            right -= 1
            maxFlag = False

        else:
            for i in range(right - 1, left - 1, -1):
                if arr[i] > arr[i + 1]:
                    arr[i], arr[i + 1] = arr[i + 1], arr[i]
                    swapFlag = True
            
            left += 1
            maxFlag = True

if __name__ == '__main__':
    cocktailShakerSort([6,5,4,3,2,1])