def rot13Char(a):
    if isCapital or a >= "a" and a <= "z":
        if isWrap(isCapital(a), a):
            return chr(ord(a) - 13)
        else:
            return chr(ord(a) + 13)
    else:
        return a
def isCapital(a):
    return a >= "A" and a <= "Z"
def isWrap(capitalize,a):
    if capitalize:
        return a >= "N" and a <= "Z"
    else:
        return a >= "n" and a <= "z"
def rot13(a):
    i = 0
    value = ""
    while i < len(a):
        value += rot13char(a[i])
    return value
        
