#Paste in this code, then test the 3 different read commands.
file = open("data.txt","r")   # r means read mode

#UNCOMMENT ONE of these sections:
#text = file.read()

#text = file.readlines()

#text = file.readline() #uncomment all 3 lines
#print "and then..." #uncomment all 3 lines
#text = file.readline() #uncomment all 3 lines

#print text
#returning the sum of a separate file
#each number is separated by a blank line
def firstGoal():
    file = open("windows.txt","r")
    x = file.readlines()
    val = 0
    i = 0
    while i < len(x):
        val += int(x[i].rstrip("\n"))
        i += 1
    return val
#stringToInt
#return sum of string divided by commas
def stringToInt(s):
    x = s.split(",")
    val = 0
    i = 0
    for j in x:
        val += int(x[i])
        i += 1
    return val
#return the sum of all of the ints in a separate file
#divided by commas
def finalGoal():
    file = open("sumfile.txt","r")
    val = 0
    i = 0
    while i <= 3:
        val += stringToInt(file.readline())
        i += 1
    return val
print firstGoal()
print finalGoal()
