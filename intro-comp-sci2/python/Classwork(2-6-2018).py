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
