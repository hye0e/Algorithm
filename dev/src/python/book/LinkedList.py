class Node:

    def __init__(self, item):
        self.data = item
        self.next = None


class LinkedList:

    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None


    def getAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
            return None

        i = 1
        curr = self.head
        while i < pos:
            curr = curr.next
            i += 1

        return curr


    def insertAt(self, pos, newNode):
        if pos < 1 or pos > self.nodeCount + 1:
            return False

        if pos == 1:
            newNode.next = self.head
            self.head = newNode

        else:
            if pos == self.nodeCount + 1:
                prev = self.tail
            else:
                prev = self.getAt(pos - 1)
            newNode.next = prev.next
            prev.next = newNode

        if pos == self.nodeCount + 1:
            self.tail = newNode

        self.nodeCount += 1
        return True


    def popAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
            raise IndexError
        curr = self.getAt(pos)
        if self.nodeCount == 1:
            print("first")
            self.nodeCount = 0
            self.head = None
            self.tail = None
        else:
            if self.nodeCount == pos:
                print("last")
                prev = self.getAt(pos - 1)
                prev.next = curr.next
            else:
                print("else last")
                prev = self.getAt(pos - 1)
                nextNode = self.getAt(pos + 1)
                prev.next = curr.next
            
            self.nodeCount -= 1
        return curr.data
        
    def traverse(self):
        result = []
        curr = self.head
        while curr is not None:
            result.append(curr.data)
            curr = curr.next
        return result


if __name__ == '__main__':
    a = Node(30)
    b = Node(24)
    c = Node(69)

    linkedList = LinkedList()
    print(linkedList.insertAt(1, a))
    print(linkedList.insertAt(2, b))
    print(linkedList.insertAt(3, c))

    print(linkedList.popAt(3)) 
    print(str(linkedList))
