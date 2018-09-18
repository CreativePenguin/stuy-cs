import string
#pig latin Lab part 1: pigLatinSimple
#add "hay" to the end of words that begin with vowels
#else, take the first letter of the word and move it to the end, then add "ay"
def isVowel(s):
    s = s.lower()
    return s in "aeiou"
def pigLatinSimple(s):
    val = ""
    if isVowel(s[0]):
        val = s + "hay"
    else:
        val = s[1:] + s[0] + "ay"
    return val
#pig latin lab part 2: pigLatin`
#For phrases in diagraphs:
#Move phrase to end, then add "ay" to end of word
#pigLatinSimple still applies
def pigLatin(s):
    if s == "":
        return ""
    diagraphs = ['bl', 'br', 'ch', 'ck', 'cl', 'cr', 'dr', 'fl', 'fr', 'gh', 'gl', 'gr', 'ng', 'ph', 'pl', 'pr', 'qu', 'sc', 'sh', 'sk', 'sl', 'sm', 'sn', 'sp', 'st', 'sw', 'th', 'tr', 'tw', 'wh', 'wr']
    test = s[:2].lower()
    if test in diagraphs:
        return s[2:] + s[:2] + "ay"
    return pigLatinSimple(s)
#pig latin lab part 3: pigLatinBest
#be able to add punctuation to the end of words
def isWord(s):
    s = s.lower()
    return s > "a" and s < "z"
def pigLatinBest(s):
    if len(s) <= 1:
        return pigLatin(s)
    elif not isWord(s[len(s) - 1]):
        return pigLatin(s[:len(s) - 2]) + s[len(s) - 1]
    else:
        return pigLatin(s)
#capitalizeSentence - capitalize every word in sentence
def breakSentence(s):
    i = 0
    val = []
    appendNum = 0
    if s == '':
      return []
    while i < len(s):
        if s[i] == " ":
            val.append(s[appendNum:i])
            appendNum = i + 1
        i += 1
    val.append(s[appendNum:])
    return val
def capitalizeSentence(s):
    if s == '':
      return ''
    x = breakSentence(s)
    val = x[0].capitalize()
    i = 1
    while i < len(x):
        val += " " + x[i].capitalize()
        i += 1
    return val
#pigLatin lab final: pigLatinMultiple
#be able to translate from a normal sentence to pig latin
def pigLatinMultiple(s):
    if s == '':
        return ''
    x = breakSentence(s)
    val = pigLatin(x[0])
    i = 1
    while i < len(x):
        val += " " + pigLatin(x[i])
        i += 1
    return val
"""
----------------------------------------------------

Alice in Wonderland Lab

----------------------------------------------------
"""
#Part 1, Question 1
#Read the file
def readFile():
    file = open("alice-simple.txt","r")
    return file.read()

#Part 1, Question 2
#Split up the file into parts

def splitFile():
    file = open("alice-simple.txt","r")
    x = file.readlines()
    i = 0
    val = []
    for j in x:
        val += x[i].strip("\n").split()
        i += 1
    return val

#Part 2, Question 1
#Translate divided bits into pig latin

def translateFile():
    file = open("alice-simple.txt","r")
    x = file.readlines()
    draft1 = []
    val = []
    for j in x:
        draft1 += j.strip("\n").split()
    for a in draft1:
        val += pigLatinBest(a).split()
    return val

#Part 2, Question 3
#Print out first hundred words in pig latin list

def printFile100():
   i = 0
   while i <= 100:
       print translateFile()[i]
       i += 1

#Part 3, Question 1
#Remove punctuation -- put it in a separate part of the list

def removePunc(s):
    if len(s) <= 1:
        return [pigLatin(s)]
    elif not isWord(s[len(s) - 1]):
        return [pigLatin(s[:len(s) - 2])] + [s[len(s) - 1]]
    else:
        return [pigLatin(s)]
def removePuncFile():
    initFile = splitFile()
    val = []
    for x in initFile:
        val += removePunc(x)
    return val

#Part 3, Question 2
#Process hyphenated words individually

def hyphenWords(s):
    counter = 1
    i = 0
    if len(s) <= 2:
        return pigLatin(s)
    while counter < len(s) - 1:
        if s[counter] == "-":
            i = counter
        counter += 1
    if i > 0:
        return pigLatinBest(s[:i]) + "-" + pigLatinBest(s[i + 1:])
    else:
        return pigLatinBest(s)
def hyphenWordsAndRemovePunc(s):
    counter = 1
    i = 0
    if len(s) <= 1:
        return [pigLatin(s)]
    if not isWord(s[len(s) - 1]):
        return [pigLatin(s[:len(s) - 2])] + [s[len(s) - 1]]
    while counter < len(s) - 1:
        if s[counter] == "-":
            i = counter
        counter += 1
    if i > 0:
        return [pigLatinBest(s[:i]) + "-" + pigLatinBest(s[i + 1:])]
    else:
        return [pigLatin(s)]

#Part 4
#Combine List and Print String

def makeSentence(l):
    if l == []:
        return ""
    i = 1
    val = l[0]
    while i < len(l):
        val += " " + l[i]
        i += 1
    return val

def printFinalList():
    i = 0
    test = ""
    val = ""
    while i < len(splitFile()):
        test += makeSentence(hyphenWordsAndRemovePunc(splitFile()[i])) + " "
        i += 1
    print test
printFinalList()
