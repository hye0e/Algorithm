class Solution:
    def mostCommonWord(paragraph, banned) -> str:
                # 소문자
        paragraph = paragraph.lower()
        # !?',;.
        paragraph = paragraph.replace('!', ' ')
        paragraph = paragraph.replace('?', ' ')
        paragraph = paragraph.replace("'", ' ')
        paragraph = paragraph.replace(',', ' ')
        paragraph = paragraph.replace(';', ' ')
        paragraph = paragraph.replace('.', ' ')

        str_list = paragraph.split()
        
        str_dict = {}
        
        for s in str_list:
            if s not in banned:
                if s not in str_dict:
                    str_dict[s] = 1
                else:
                    str_dict[s] += 1            
        
        max_value = 0
        answer = ''
        for key in str_dict:
            if str_dict[key] > max_value:
                answer = key
                max_value = str_dict[key]

        return answer

    def mostCommonWord(paragraph, banned) -> str:
        word = [word for word in re.sub(r'[^\w]', ' ', paragraph)
                            .lower().split() 
                                    if word not in banned]

        counts = collections.Counter(words)
        # most_common(1): 가장 흔하게 등장하는 단어의 첫번째 값을 추출
        # [('ball', 2)]
        return counts.most_common(1)[0][0] 