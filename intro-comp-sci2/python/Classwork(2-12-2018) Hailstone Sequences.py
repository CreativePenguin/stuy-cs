def hailstoneSequence(n):
    print n,
    while n > 1:
        if n % 2 > 0:
            n = (3 * n) + 1
            print n,
        if n % 2 == 0:
            n = n / 2
            print n,
