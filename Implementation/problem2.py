from typing import List

def is_badword(dic, chat):
    stop = len(chat) if len(chat) < len(dic) else len(dic)
    index = 0
    while index < stop:
        if chat[index] != dic[index]:
            if chat[index] == '.':
                index += 1
                continue
            
            return False
        index += 1
    return True


def solution(k: int, dic: List[str], chat: str) -> str:
    answer = ''
    chat_list = chat.split()
    for idx, ch in enumerate(chat_list):
        flag = False
        for bad in dic:
            flag = is_badword(bad, ch)
            if flag:
                break
            
        if flag:
            answer += '#' * len(ch)
        else:
            answer += ch

        if idx != len(chat_list) - 1:
            answer += ' '

    return answer

if __name__ == '__main__':
    # "####### ab.cd ####### .word #### bad.word"
    # solution(2, ["slang", "badword"], "badword ab.cd bad.ord .word sl.. bad.word")
    print(solution(3, ["abcde", "cdefg", "efgij"], ".. ab. cdefgh .gi. .z."))