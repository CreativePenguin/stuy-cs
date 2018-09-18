def rot13Char(c):
    value = ""
    if isLetter(c):
        if c >= "n" and c <= "z" or c >= "N" and c <= "Z":
            value = chr(ord(c) - 13)
        else:
            value = chr(ord(c) + 13)
    else:
        value = c
    return value
def isLetter(c):
    return c >= "A" and c <= "Z" or c >= "a" and c <= "z"
def isCapital(c):
    return c >= "A" and c <= "Z"
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
def rot13(s):
    i = 0
    value = ""
    while i < len(s):
        value += rot13Char(s[i])
        i += 1
    return value
def rotX(s,x):
    i = 0
    value = ""
    while i < len(s):
        value += rotXChar(s[i],x)
        i += 1
    return value
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
