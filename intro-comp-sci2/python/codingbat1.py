#    evalQuadratic

def evalQuadratic(a,b,c,x):
    return a * (x ** 2) + b * x + c

#    magicPair

def magicPair(a,b):
  if onesDigit(a) == onesDigit(b):
    return onesDigit(a) + onesDigit(b) == tensDigit(a) + tensDigit(b)
  if onesDigit(a) == tensDigit(b):
    return onesDigit(a) + tensDigit(b) == tensDigit(a) + onesDigit(b)
  if tensDigit(a) == tensDigit(b):
    return tensDigit(a) + tensDigit(b) == onesDigit(a) + onesDigit(b)
  if tensDigit(a) == onesDigit(b):
    return tensDigit(a) + onesDigit(b) == onesDigit(a) + tensDigit(b)
  else:
    return False

#    sumSquaresBetween

def sumSquaresBetween(a,b):
    i = 0
    x = 0
    while i ** 2 < a:
        i += 1
    while i ** 2 <= b:
        x += i ** 2
        i += 1
    return x

#    specialSumInc

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

#    sumOfPowers

def sumOfPowers(n):
    i = 1
    x = 0
    while 2 ** i <= n:
        x += 2 ** i
        i += 1
    return x

#    countOddDigits

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

#    countPrimeDigits

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
