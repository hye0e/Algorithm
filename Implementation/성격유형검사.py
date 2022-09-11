def solution(survey, choices):
    # ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	
    answer = ''
    result = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}

    for i in range(len(survey)):
        if choices[i] == 4:
            continue

        if choices[i] == 1:
            result[list(survey[i])[0]] += 3
        elif choices[i] == 2:
            result[list(survey[i])[0]] += 2
        elif choices[i] == 3:
            result[list(survey[i])[0]] += 1
        elif choices[i] == 5:
            result[list(survey[i])[1]] += 1
        elif choices[i] == 6:
            result[list(survey[i])[1]] += 2
        elif choices[i] == 7:
            result[list(survey[i])[1]] += 3

    answer += 'R' if result['R'] >= result['T'] else 'T'
    answer += 'C' if result['C'] >= result['F'] else 'F'
    answer += 'J' if result['J'] >= result['M'] else 'M'
    answer += 'A' if result['A'] >= result['N'] else 'N'

    return answer

if __name__ == '__main__':
    print(solution(["AN", "CF", "MJ", "RT", "NA"],	[5, 3, 2, 7, 5]))