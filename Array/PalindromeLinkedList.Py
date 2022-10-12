def isPalindrome(head):
    while head:
        if head.pop(0) != head.pop():
            return False

    return True


print(isPalindrome([1, 2, 2, 1]))