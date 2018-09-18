def isLetter(c):
    return c >= "A" and c <= "Z" or c >= "a" and c <= "z"
def isCapital(c):
    return c >= "A" and c <= "Z"

#    rot13

def rot13(s):
    i = 0
    value = ""
    while i < len(s):
        value += rot13Char(s[i])
        i += 1
    return value

#    rotXchar

def rotXChar(a,n):
    newn = n % 26
    value = newn + ord(a)
    if isLetter(a):
        if isCapital(a) and not isCapital(chr(value)):
            return chr(ord("A") + value - ord("Z") - 1)
        elif isLetter(chr(value)):
            return chr(value)
        elif value >= ord("z"):
            return chr(ord("a") + value - ord("z") - 1)
        else:
            return chr(ord("A") + value - ord("Z") - 1)
    else:
        return a

#    rotX

def rotX(s,x):
    i = 0
    value = ""
    while i < len(s):
        value += rotXChar(s[i],x)
        i += 1
    return value

#    myInt

def myInt(s):
    i = 0
    value = 0
    fval = 0
    if ord(s[0]) == 45:
        i += 1
    while i < len(s):
        value *= 10
        value += ord(s[i]) - 48
        i += 1
    if ord(s[0]) == 45:
        value *= -1
    return value

#    plusOut

def plusOut(s,word):
    i = 0
    value = ""
    booboo = False
    while i < len(s) - len(word) + 1:
        test = s[i:i + len(word)]
        if test == word:
            value += test
            booboo = True
        elif booboo == False:
            value += "+"
        else:
            booboo = False
        i += 1
    if not word == s[len(s) - len(word):len(s)]:
        value += "+"
    return value

#    xyBalance

def xyBalance(s):
    i = 0
    isBalance = True
    while i < len(s):
        if s[i] == "x":
            isBalance = False
        if s[i] == "y":
            isBalance = True
        i += 1
    return isBalance

#    noConsecutiveCapsSpecial

def noConsecutiveCapsSpecial(s):
    i = 1
    while i < len(s):
        if isCapital(s[i]) and isCapital(s[i + 1]):
            return False
    return True

#    sameStartChar

def sameStartChar(s):
    i = 0
    isSameChar = True
    while i < len(s):
        if s[i] == "*" and i < len(s) - 1:
            if isLetter(s[i - 1]) and isLetter(s[i + 1]):
                isSameChar = s[i- 1] == s[i + 1]
        i += 1
    return isSameChar
