def makeHail(n):
    val = []
    while n > 1:
        if n % 2 == 0:
            val.append(n)
            n /= 2
        else:
            val.append(n)
            n = n * 3 + 1
    return val
"""
print makeHail(8)
print makeHail(5)
"""
def swapStuff(w):
    first = w[0]
    last = w[len(w) - 1]
    return [last] + w[1:len(w)-1] + [first]
"""
print swapStuff(["a","b","c","j","k"])
print swapStuff(["jk","fantastic","beast","haha"])
"""

def removeNegs(s):
    i = 0
    while i < len(s):
        if s[i] < 0:
            s.remove(s[i])
            i -= 1
        i += 1
    return s
"""
print removeNegs([3,4,5,-1,-37,-1202034]),[3,4,5]
print removeNegs([-5,-12343,-12935993]),[]
print removeNegs([-10,5,-123450451,12]),[5,12]
"""
def moveNegsToEnd(s):
    i = 0
    while i < len(s):
        if s[i] < 0:
            s.append(s[i])
            s.remove(s[i])
        i += 1
    return s
"""
print moveNegsToEnd([123,-343,434343]),[123,434343,-343]
print moveNegsToEnd([-1,1,-1,1,-1,-1,1,1,1]),[1,1,1,1,1,-1,-1,-1,-1,-1]
print moveNegsToEnd([694,254,360,2601,3419,4613]),[694,254,360,2601,3419,4613]
print moveNegsToEnd([101,-363,216,-15]),[101,216,-363,-15]
"""
