def sumFromZeroToN(n):
    if n < 0:
        return 0
    i = 0
    a = 0
    while i <= n:
        a += i
        i += 1
    return a

def sumAtoB(a,b):
    if a > b:
        return 0
    i = a
    x = 0
    while i <= b:
        x += i
        i += 1
    return x

def fiveSumFromZeroToN(n):
    if n < 0:
        return 0
    i = 0
    x = 0
    while i <= n:
        x += i
        i += 5
    return x

def specialSumInclusive(n):
    if n <= 0:
        return 0
    i = 0
    x = 0
    while i <= n:
        if i % 3 == 0 or i % 5 == 0:
            x += i
        i += 1
    return x

def specialSumExclusive(n):
    if n <= 0:
        return 0
    i = 0
    x = 0
    while i <= n:
        if i % 5 == 0 and i % 7 ==0:
            x += i
        i += 1
    return x


def sumOfFirstNSquares(n):
    i = 0
    x = 0
    if n  <= 0:
        return 0
    while i <= n:
        x += i ** 2
        i += 1
    return x

def sumSquaresBetween(a,b):
    i = 0
    x = 0
    while i ** 2 < a:
        i += 1
    while i ** 2 <= b:
        x += i ** 2
        i += 1
    return x

def sumOfPowers(n):
    i = 1
    x = 0
    while 2 ** i <= n:
        x += 2 ** i
        i += 1
    return x

def sumDigits(n):
    if n < 0:
        n = n * -1
    i = 1
    x = 0
    while i <= n:
        x = x + ((n / i) % 10)
        i =i * 10
    return x

def countDigits(n):
    if n == 0:
        return 1
    if n < 0:
        n *= -1
    i = 1
    x = 0
    while n / i > 0:
        i *= 10
        x += 1
    return x

def countOddDigits(n):
    if n < 0:
        n *= -1
    i = 1
    x = 0
    while n / i > 0:
        if (n / i) % 2 > 0:
            x += 1
        i *= 10
    return x

def countPrimeDigits(n):
    i = 1
    x = 0
    if n < 0:
        n *= -1
    while n / i> 0:
        if getDigit(n,i) == 2:
            x += 1
        if getDigit(n,i) == 3:
            x += 1
        if getDigit(n,i) == 5:
            x += 1
        if getDigit(n,i) == 7:
            x += 1
        i *= 10
    return x
def getDigit(num,digit):
    return (num / digit) % 10
