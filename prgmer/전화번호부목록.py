def solution(phoneBook):
    phoneBook = sorted(phoneBook)

    for p1, p2 in zip(phoneBook, phoneBook[1:]):
        print(p1, p2)
        if p2.startswith(p1):
            return False
    return True

if __name__ == '__main__':
    solution(["119", "97674223", "1195524421"])