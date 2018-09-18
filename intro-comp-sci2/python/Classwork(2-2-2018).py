def isBetween(number,a,b):
    isBigA = number > a
    isBigB = number > b
    isSmallA = number < a
    isSmallB = number < b
    return isBigA and isSmallB or isBigB and isSmallA





print isBetween(1,2,3)
print isBetween(300,50,350)
print isBetween(3,2,1)
