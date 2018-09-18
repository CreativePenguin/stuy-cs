def shiftCharacterByOne(c):
    return chr(ord(c) + 1)

def shiftCharacter(c,n):
    return chr(ord(c) + n)

def shiftWordByOne(s):
    i = 0
    value = ""
    while i < len(s):
        value += shiftCharacterByOne(s[i])
        i += 1
    return value

def shiftWord(s,n):
    i = 0
    value = ""
    while i < len(s):
        value += shiftCharacter(s[i],n)
        i += 1
    return value

def myUpper(s):
    i = 0
    value = ""
    while i < len(s):
        if s[i] >= "a" and s[i] <= "z":
            value += chr(ord(s[i]) - 32)
        else:
            value += s[i]
        i += 1
    return value

def myCapitalize(s):
    if s == '':
        return ''
    bs = s[0].upper()
    es = s[1:len(s)].lower()
    return bs + es
