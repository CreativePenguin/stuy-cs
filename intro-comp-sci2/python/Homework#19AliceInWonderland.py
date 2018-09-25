def sumValues():
    file = open("values-windows.txt","r")
    x = file.readlines()
    val = 0
    i = 0
    while i < len(x):
        val += float(x[i].rstrip("\n"))
        i += 1
    return val
def aliceInWonderland():
    file = open("alice-simple.txt","r")
    x = file.readlines()
    val = ""
    i = 0
    while i < len(x):
        print pigLatinMultiple(x[i].strip())
        #value += float(pigLatinMultiple(x))
        i += 1
    #return val

#PIG LATIN LAB

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
    diagraphs = ['bl', 'br', 'ch', 'ck', 'cl', 'cr', 'dr', 'fl', 'fr', 'gh', 'gl', 'gr', 'ng', 'ph', 'pl', 'pr', 'qu', 'sc', 'sh', 'sk', 'sl', 'sm', 'sn', 'sp', 'st', 'sw', 'th', 'tr', 'tw', 'wh', 'wr']
    test = s[:2].lower()
    if test in diagraphs:
        return s[2:] + s[:2] + "ay"
    return pigLatinSimple(s)
#pig latin lab part 3: pigLatinBest
#be able to add punctuation to the end of words
def pigLatinBest(s):
    if not isWord(s[len(s) - 1]):
        punc = s[len(s) - 2]
        return pigLatin(s[:len(s) - 1]) + punc
def isWord(s):
    s = s.lower()
    return s < "a" and s > "z"
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

#PRINT values
print sumValues()
aliceInWonderland()
