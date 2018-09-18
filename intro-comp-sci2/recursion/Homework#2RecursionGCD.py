def gcdLoop(a,b):
    if a > b:
        print a, b
        while a > 1 and b > 1:
            if a > b:
                a = a - b
            else:
                b = b - a
        return a
    else:
        gcdLoop(b,a)
"""
print gcdLoop(4,3)
print gcdLoop(694,254)
print gcdLoop(63, 81)
print gcdLoop(360,90)
print gcdLoop(220,30)
"""

def gcdRecursion(a,b):
    #if a > b:
        if a - b == 1:
            return 1
        if a <= 1 or b <= 1:
            return b
        elif a - b > b - a:
            #print a - b
            return gcdRecursion(a-b,b)
        else:
            #print b - a
            return gcdRecursion(b - a,a)
    #else:
        #gcdRecursion(b,a)
"""
print gcdRecursion(4,3)
print gcdRecursion(694,254)
print gcdRecursion(63,81)
print gcdRecursion(360,90)
print gcdRecursion(220,30)
print gcdRecursion(100,99)
"""
