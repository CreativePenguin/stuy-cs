#makeListOneToN
def makeListOneToN(n):
    i = 1
    val = []
    while i <= n:
        val.append(i)
        i += 1
    return val
#makeHailList
def makeHailList(n):
    val = []
    case = n
    while case > 1:
        val.append(case)
        if case % 2 == 0:
            case /= 2
        else:
            case = 3 * case + 1
    val.append(1)
    return val
#makeListNEvens
def makeListNEvens(n):
    val = []
    i = 0
    a = 0
    while i < n:
        val.append(a)
        i += 1
        a += 2
    return val
#makeEvenListToN
def makeEvenListToN(n):
    val = []
    i = 0
    while i <= n:
        val.append(i)
        i += 2
    return val
#makeFibList
def makeFibList(n):
    val = [0]
    i = 0
    a = 1
    b = 0
    while i < n - 1:
        a += b
        val.append(a)
        b += a
        val.append(b)
        i += 2
    if not n % 2 == 0:
        a += b
        val.append(a)
    return val
