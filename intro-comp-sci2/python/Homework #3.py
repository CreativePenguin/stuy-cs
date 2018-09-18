def diff21(n):
    if n <= 21:
        return abs (21 - n)
    else:
        return abs (21 - n) * 2

def no_teen_sum(a,b,c):
    if fix_teen(a):
        a = 0
    if fix_teen(b):
        b = 0
    if fix_teen(c):
        c = 0
    return a+b+c
def fix_teen(n):
    if n == 15 or n == 16:
        return False
    if n >= 13 and n <= 19:
        return True
    else:
        return False

def sorta_sum(a,b):
    if a + b >= 10 and a + b <= 19:
        return 20
    else:
        return a+b

def lone_sum(a,b,c):
    if a == b and a == c:
        a = 0
        b = 0
        c = 0
    if a == b:
        a = 0
        b = 0
    if a == c:
        a = 0
        c = 0
    if b == c:
        b = 0
        c = 0
    return a+b+c

def lucky_sum(a,b,c):
    if a == 13:
        a = 0
        b = 0
        c = 0
    if b == 13:
        b = 0
        c = 0
    if c == 13:
        c = 0
    return a+b+c

def round_sum(a, b, c):
    return round10(a) + round10(b) + round10(c)
def round10(num):
    if num % 10 >= 5:
        x = 10 - (num % 10)
        return x + num
    if num % 10 < 5:
        x = num % 10
        return num - x

def make_bricks(small,big,goal):
    one = small
    five = big * 5
    if five > goal:
        five = goal - (goal % 5)
    remainder = goal - five
    return one >= abs(remainder)

def close_far(a,b,c):
    return abs(a-b)<=1 and abs(a-c)>=2 and abs(b-c)>=2 or abs(a-c)<=1 and abs(a-b)>=2 and abs(b-c)>=2
