def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)
def printFib(n):
    i = 0
    while i <= n:
        print i, fib(i)
        i += 1
