import math
def fibonacci(a):
    x = 0
    y = 1
    counter = 0
    print 1
    while counter < (a-1):
        x += y
        print x
        y += x
        print y
        counter = counter + 2
#print fibonacci(9)
def isPrime(a,n):
    if a == 2:
        return True
    if n == 1:
        return True
    if a % n == 0:
        return False
    else:
        return isPrime(a,n-1)
print isPrime(3,2)
print isPrime(2,1)
print isPrime(100,99)
