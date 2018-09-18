def isalnum(s):
    if len(s) == 0:
        return False
    counter = 0
    while counter < len(s):
        if not isalpha(s[counter]) or isnum(s[counter]):
            return False
        counter += 1
    return True
def isalpha(c):
    return "a" <= c and "z" >= c or "A" <= c and "Z" >= c
def isnum(c):
    return 0 <= c and 9 >= c

def myInt(s):
    i = 0
    b = 0
    while i < len(s) :
        a = ord(s[i]) - 48
        b *= 10
        b += a
        i += 1
    return b
def buildString(s,i):
    counter = 0
    while counter < len(s):
        a = s[counter]
        
