def countLetter(string,letter):
    counter = 0
    value = 0
    
    while counter < len(string):
        if letter == string[counter]:
            value += 1
        counter += 1
    return value

def findLetter(original,letter):
    counter = 0

    while counter < len(original):
        if letter == original[counter]:
            return counter
        counter += 1
    return -1

def findWord(string,word):
    counter = 0

    while counter < len(string):
        if word == string[counter:counter + len(word)]:
            return counter
        counter += 1
    return -1

def countWord(original,word):
    counter = 0
    value = 0

    while counter < len(original):
        if word == original[counter:counter + len(word)]:
            value += 1
        counter += 1
    return value

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

def countVowels(s):
    counter = 0
    value = 0
    while counter < len(s):
        if isVowel(s[counter]):
            value += 1
        counter += 1
    return value

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
        
def isConsonant(c):
    if isVowel(c):
        return False
    if len(c) > 1:
        return False
    if c == "*":
        return False
    return True
