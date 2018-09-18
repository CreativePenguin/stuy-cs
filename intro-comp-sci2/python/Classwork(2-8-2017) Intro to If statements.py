def evenNumbers():
    n = 0
    while n < 30:
        n += 2
        print n

def multiplesOf3():
    n = 9
    while n < 60:
        n += 3
        print n

def perfectSquares():
    n = 1
    while n ** 2 < 5000:
        print n ** 2
        n = n + 1

def squares():
    n = 1
    while n <= 104:
        print n ** 2
        n = n + 1
        

def sumMultiplesOf5():
    n = 0
    x = 0
    while n < 3000:
        x = x + n
        n = n + 5
    return x

def sumMultiplesOf7():
    n = 0
    x = 0
    while n < 3000:
        x = x + n
        n = n + 7
    return x

def sumMultiplesOf5n7():
    i = 1
    x = 0
    while i <= 3000:
        if i % 5 or i % 7 == 0:
            x += i
        i += 1
    return x
