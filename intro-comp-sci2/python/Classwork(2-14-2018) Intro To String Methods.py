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

def isVowel(s):
    counter = 0
    value = 0

    while 
