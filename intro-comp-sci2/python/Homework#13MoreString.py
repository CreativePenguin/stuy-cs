def repeatFront(s,n):
    n1 = n
    cut = s[0:n]
    value = ""
    i = 0
    while i <= n1:
        value += cut
        i += 1
        n -= 1
        cut = s[0:n]
    return value

def getSandwich(s):
    startIndex = findWord(s,"bread") + len("bread")
    newString = s[startIndex:len(s)]
    endIndex = findWordReverse(newString,"bread")
    return s[startIndex:endIndex + startIndex]
def findWord(string,word):
    counter = 0
    while counter < len(string):
        if word == string[counter:counter + len(word)]:
            return counter
        counter += 1
    return -1
def findWordReverse(string,word):
    counter = len(string)
    while counter > 0:
        if word == string[counter - len(word):counter]:
            return counter - len(word)
        counter -= 1
    return -1

def isCap(c):
    return c >= "A" and c <= "Z"

def hasThreeCaps(s):
    counter = 0
    while counter < len(s) - 2:
        if isCap(s[counter]) and isCap(s[counter + 1]) and isCap(s[counter + 2]):
            return True
        counter += 1
    return False

def noConsecutiveCaps(s):
    counter = 0
    while counter < len(s) - 1:
        if isCap(s[counter]) and isCap(s[counter + 1]):
            return False
        counter += 1
    return True

def noConsecutiveCapsSpecial(s):
    i = 1
    while i < len(s) - 1:
        if isCapital(s[i]) and isCapital(s[i + 1]):
            return False
        i += 1
    return True

def isLetter(c):
    return c >= "A" and c <= "Z" or c >= "a" and c <= "z"
def sameStartChar(s):
    i = 0
    isSameChar = True
    while i < len(s):
        if s[i] == "*" and i < len(s) - 1:
            if isLetter(s[i - 1]) and isLetter(s[i + 1]):
                isSameChar = s[i- 1] == s[i + 1]
        i += 1
    return isSameChar
