import sys

n = int(sys.stdin.readline())

words = []
alpha_dict = {} 

for i in range(n):
    words.append(sys.stdin.readline().rstrip())

for word in words:
    square_root = len(word) - 1
    for c in word:
        if c in alpha_dict:
            alpha_dict[c] += pow(10, square_root)
        else:
            alpha_dict[c] = pow(10, square_root)
        square_root -= 1

alpha_dict = sorted((alpha_dict.values()), reverse= True)
result = 0
max_num = 9
for value in alpha_dict:
    result += value * max_num
    max_num -= 1

print(result)