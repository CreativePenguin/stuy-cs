def isLetter(c):
    return c >= "A" and c <= "Z" or c >= "a" and c <= "z"

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

def sameStartChar(s):
    i = 0
    isSameChar = True
    while i < len(s):
        if s[i] == "*" and i < len(s) - 1:
            if isLetter(s[i - 1]) and isLetter(s[i + 1]):
                isSameChar = s[i- 1] == s[i + 1]
        i += 1
    return isSameChar

def noConsecutiveCaps(s):
    i = 0
    while i < len(s):
        if isCapital(s[i]) and isCapital(s[i + 1]):
            return False
    return True
    
def noConsecutiveCapsSpecial(s):
    i = 1
    while i < len(s):
        if isCapital(s[i]) and isCapital(s[i + 1]):
            return False
    return True
