def ftoc(f):
    return (f - 32.0) * 5 / 9

def ctof(c):
    return c * 9.0 / 5 + 32

def evalQuadratic(a,b,c,x):
    return a * (x ** 2) + b * x + c

def pos_neg(a,b,negative):
    return a > 0 and b < 0 and negative == False or a < 0 and b > 0 and negative == False or a < 0 and b < 0 and negative == True

def near_hundred (n):
    return abs(100 - n) <= 10 or abs (200 - n) <= 10
