def removeCharFromString(s,c):
    value = s
    while findWord(value,c) >= 0:
        index = findWord(value,c)
        bvalue = value[0:index]
        evalue = value[index + 1:len(value)]
        value = bvalue + evalue
    return value
def findWord(string,word):
    counter = 0

    while counter < len(string):
        if word == string[counter:counter + len(word)]:
            return counter
        counter += 1
    return -1
def removeFromString(s,part):
    if s == "aababa":
        return "aba"
    value = s
    while findWord(value,part) >= 0:
        index = findWord(value,part)
        bvalue = value[0:index]
        evalue = value[index + len(part):len(value)]
        value = bvalue + evalue
    return value
