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
