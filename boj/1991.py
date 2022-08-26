# -*- coding: utf-8 -*-
import sys

input = sys.stdin.readline

num = int(input())
tree = {}

for i in range(num):
    root, left, right = input().split()
    tree[root] = [left, right]

print(tree)
# preorder(전위순회) = (루트)(왼쪽자식)(오른쪽자식)
def preorder(root):
    if root != '.':
        print(root,end='') # 루트 
        preorder(tree[root][0]) # 왼쪽
        preorder(tree[root][1]) # 오른쪽

# inorder(중위순회) = (왼쪽자식)(루트)(오른쪽자식)
def inorder(root):
    if root != '.':
        inorder(tree[root][0]) # 왼쪽
        print(root, end='') # 루트
        inorder(tree[root][1]) # 오른쪽

# postorder(후위순회) = (왼쪽자식)(오른쪽자식)(루트)
def postorder(root):
    if root != '.':
        postorder(tree[root][0]) # 왼쪽
        postorder(tree[root][1]) # 오른쪽
        print(root, end='') # 루트

preorder('A')
print()
inorder('A')
print()
postorder('A')