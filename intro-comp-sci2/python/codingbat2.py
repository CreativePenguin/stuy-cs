#    maxHail

def hailLen(n):
    counter = 1
    while n > 1:
        if n % 2 > 0:
            n = (3 * n) + 1
            counter += 1
        if n % 2 == 0:
            n /= 2
            counter += 1
    return counter
def maxHail(z):
    maxLen = 0
    val = 0
    while z >= 1:
        if hailLen(z) > maxLen:
            maxLen = hailLen(z)
            val = z
        z -= 1
    return val

#    maxHailRange

def maxHailRange(low,high):
    maxLen = 0
    val = 0
    while high >= low:
        if hailLen(high) >= maxLen:
            maxLen = hailLen(high)
            val = high
        high -= 1
    return val
def hailLen(n):
    counter = 1
    while n > 1:
        if n % 2 > 0:
            n = (3 * n) + 1
            counter += 1
        if n % 2 == 0:
            n /= 2
            counter += 1
    return counter

#    countWord

def countWord(original,word):
    counter = 0
    value = 0

    while counter < len(original):
        if word == original[counter:counter + len(word)]:
            value += 1
        counter += 1
    return value

#    findWord

def findWord(string,word):
    counter = 0

    while counter < len(string):
        if word == string[counter:counter + len(word)]:
            return counter
        counter += 1
    return -1

#    noVowels

def isVowel(letter):
    if letter == "a" or letter == "A":
        return True
    if letter == "e" or letter == "E":
        return True
    if letter == "i" or letter == "I":
        return True
    if letter == "o" or letter == "O":
        return True
    if letter == "u" or letter == "U":
        return True
    return False

def noVowels(s):
    counter = -1
    value = s
    while counter < len(value) - 1:
        counter += 1
        if isVowel(value[counter]):
            value = removeLetter(counter,value)
            counter -= 1
    return value

def removeLetter(index,s):
    return s[0:index] + s[index + 1:len(s)]

#    shiftWordByOne

def shiftWordByOne(s):
    i = 0
    value = ""
    while i < len(s):
        value += shiftCharacterByOne(s[i])
        i += 1
    return value
def shiftCharacterByOne(c):
    return chr(ord(c) + 1)

#    shiftWord

def shiftWord(s,n):
    i = 0
    value = ""
    while i < len(s):
        value += shiftCharacter(s[i],n)
        i += 1
    return value
def shiftCharacter(c,n):
    return chr(ord(c) + n)

#    myUpper

def isLower(c):
    return c <= "z" and c >= "a"
def myUpper(c):
    value = ""
    i = 0
    while i < len(c):
        if isLower(c[i]):
            value += chr(ord(c[i]) - 32)
        i += 1
    return value

#    myCapitalize

def myCapitalize(s):
    return s[0].upper() + s[1:len(s)].lower()
