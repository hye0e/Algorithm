max_plus_cnt = 0
max_costs = 0

def solution(users, emoticons):
    solve(0, users, [0 for _ in range(len(emoticons))], emoticons)
    return [max_plus_cnt, max_costs]

def solve(cnt, users, discounts, emoticons):
    global max_plus_cnt
    global max_costs

    if cnt == len(emoticons):
        plus_cnt, costs = getResult(users, discounts, emoticons)
        if max_plus_cnt < plus_cnt:
            max_plus_cnt = plus_cnt
            max_costs = costs
        elif max_plus_cnt == plus_cnt:
            max_costs = costs if costs > max_costs else max_costs
        return

    for dscnt in range(10, 50, 10): # 할인율 10, 20, 30, 40
        discounts[cnt] = dscnt
        solve(cnt + 1, users, discounts, emoticons)
    
    

def getResult(users, discounts, emoticons):
    discounted = [ (100 - discounts[i]) * emoticons[i] / 100 for i in range(len(emoticons)) ]
    
    plus_cnt = 0
    costs = 0
    for user in users:
        total_price = 0
        for i in range(len(discounted)):
            if discounts[i] >= user[0]:
                total_price += discounted[i]
        if total_price >= user[1]:
            plus_cnt += 1
        else:
            costs += total_price

    return [plus_cnt, costs] 

if __name__ == '__main__':
    solution([[40, 10000], [25, 10000]], [7000, 9000])