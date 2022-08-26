def sum(num):
    total = 0
    for i in range(num):
        total += i
        printTotal(total)
    return total

def printTotal(total):
    print('wait...')
    print('total : ' + str(total))
    print('print complete')

result = sum(3)
print(result)