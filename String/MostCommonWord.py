def mostCommonWord(paragraph, banned):
        # 소문자
        paragraph = paragraph.lower()
        # !?',;.
        paragraph = paragraph.replace('!', '')
        paragraph = paragraph.replace('?', '')
        paragraph = paragraph.replace("'", '')
        paragraph = paragraph.replace(',', '')
        paragraph = paragraph.replace(';', '')
        paragraph = paragraph.replace('.', '')

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

mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"])