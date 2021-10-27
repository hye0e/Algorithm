import sys

str = sys.stdin.readline()

print(str.replace('+', '').replace('-', '|'))
arr = list(map(int, str.replace('-', '-1').split('-1')))