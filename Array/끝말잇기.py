def is_valid(word1, word2):
    if word1 == '':
        return True
    return word1[-1] == word2[0]

def solution(n, words):
    use_word = []
    last = ''
    cnt = 1
    while words:
        for i in range(0, n):
            word = words[i]
            # 한번 사용한 언어는 안됨
            if word in use_word:
                return [i + 1, cnt]
            # 첫글자 마지막 글자 체크
            if is_valid(last, word):
                last = word
            else:
                return [i + 1, cnt]
            use_word.append(last)
        words = words[n:]
        cnt += 1

    return [0, 0]

solution(2, ["hello", "one", "even", "never", "now", "world", "draw"])
