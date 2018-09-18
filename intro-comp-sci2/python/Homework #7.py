def hello(name):
    print "hello " + name

def firsthalf(s):
    print s[0:(len(s) / 2)]

def count(s,letter):
    counter = 0
    value = 0
    while counter < len(s):
        if s[counter] == letter:
            value += 1
        counter += 1
    return value

def find(s,letter):
    counter = 0
    while counter < len(s):
        if s[counter] == letter:
            return counter
        counter += 1
    return -1

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
