from collections import Counter

def solution(participant, completion):
    answer = Counter(participant) - Counter(completion)
    return answer.keys()[0]

if __name__ == '__main__':
    
    # participant = ["mislav", "stanko", "mislav", "ana"]	
    participant = ["leo", "kiki", "eden"]	
    # completion = ["stanko", "ana", "mislav"]
    completion = ["eden", "kiki"]	
    # print(participant.count('kiki'))
    print(solution(participant, completion))