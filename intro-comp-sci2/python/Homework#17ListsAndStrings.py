#makeSentence (join list with spaces)
def makeSentence(l):
    if l == []:
        return ""
    i = 1
    val = l[0]
    while i < len(l):
        val += " " + l[i]
        i += 1
    return val
#removeOuterSpaces (removes spaces not between words)
def removeOuterSpaces(s):
    val = s[leftWordIndex(s):rightWordIndex(s)]
    return val
def leftWordIndex(a):
    i = 0
    while i < len(a) and a[i] == " ":
        i += 1
    return i
def rightWordIndex(a):
    i = len(a) - 1
    while i >= 0 and a[i] == " ":
        i -= 1
    return i + 1
#breakSentence, reverse of makeSentence
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
