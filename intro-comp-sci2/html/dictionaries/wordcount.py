#!/usr/bin/python
print "Content-type: text/html\n"
import cgitb
import string
import random
cgitb.enable()

rand = random.randint(0,3)
#rand = 0
if rand == 0:
	file = open('warsmall.txt','r')
elif rand == 1:
	file = open('frank.txt','r')
elif rand == 2:
	file = open('war.txt','r')
elif rand == 3:
	file = open('alice.txt','r')

file = file.read()
if '\r\n' in file:
        #print 'windows'
        file = file.replace('\r\n','\n')

header = '''<!DOCTYPE html>
<html>
	<head>
		<title> There's no more counting dollars because we'll be counting stars. Also we have no dollars to count </title>'''

css = '''		<style>
			//css goes here
		</style>
'''

def title():
	if rand == 0:
		return 'War of The Worlds Diet Edition'
	if rand == 1:
		return 'Frankenstein\'s Monster'
	if rand == 2:
		return 'War of the Worlds Big Boy Edition'
	if rand == 3:
		return 'Alice in Wunderlund'

headFoot = '''	</head>
	<body>''' + '<h1> ' + title() + '</h1>'

foot = '''	</body>
</html>'''

def printWeb():
	print header
	#print css
	print headFoot
	print bodyCode()
	print foot

def tally(l):
	val = {}
	for i in l:
		if i in val:
			val[i] = val[i] + 1
		else:
			val[i] = 1
	return val

def invertDict(d):
    keys = []
    vals = []
    val = {}
    counter = 0
    for i in d.keys():
        keys.append(i)
    #return keys
    for i in d.keys():
        vals.append(d[i])
    #return vals
    while counter < len(d.keys()):
        if vals[counter] in val.keys():
            val[vals[counter]].append(keys[counter])
        else:
            val[vals[counter]] = [keys[counter]]
        counter += 1
    return val

#list of all the words
def listFile():
	return file.split()

def punctlessFile():
	i = 0
	val = listFile()
	while i < len(val):
		if val[i][len(val[i]) - 1] in string.punctuation:
			val[i] = val[i][:len(val[i]) - 1]
		i += 1
	return val

def countCharacters():
	return len(file)

def lowercaseList():
	val = []
	#val = punctlessFile()
	for x in punctlessFile():
		val.append(x.lower())
	return val

def tallyList():
    return tally(lowercaseList())

def valTallyList():
	val = []
	for x in tallyList().keys():
		val.append(tallyList()[x])
	return val

def uniqueWords():
	val = 0
	for x in tallyList():
		if tallyList()[x] == 1:
			val += 1
	return val

def longWords():
	val = []
	for x in punctlessFile():
		if len(x) >= 15:
			val.append(x)
	return val
'''
def commonWords():
	newtallyList = tallyList()
	newvalTallyList = valTallyList()
	i = 1
	j = 0
	val = []
	for x in range(100):
		maxNum = max(newvalTallyList)
		maxIndex = newvalTallyList.index(maxNum)
		val.append(newtallyList.keys()[maxIndex])
		newtallyList.keys().remove(newtallyList.keys()[maxIndex])
		newvalTallyList.remove(max(newvalTallyList))
		if maxNum == max(newvalTallyList):
			i -= 1
			j += 1
		else:
			i += j
			j = 0
			print x, val, maxNum, '<br>'
			val = []
		i += 1
'''

def commonWordsMain():
	if len(invertDict(tallyList())) < 250:
		print len(invertDict(tallyList())), 'most common words <br>', commonWords(len(invertDict(tallyList())))
	else:
		print "250 most common words", commonWords(250)

def commonWords(y):
	invertTally = invertDict(tallyList())
	newtallyList = invertDict(tallyList()).keys()
	newtallyList.sort()
	newtallyList = newtallyList[::-1]
	#return newtallyList
	i = 0
	while i <= y:
		counter = newtallyList[i]
		print i, invertTally[counter], counter, '<br>'
		i += len(invertTally[counter])

def bodyCode():
	#print listFile(), '<br>'
	#print punctlessFile(), '<br>'
	#print lowercaseList(), '<br>'
	#print tallyList()

	print countCharacters(), 'Total characters in book <br>'
	print len(punctlessFile()), 'Total words in book <br>'
	print len(tallyList()), 'Different words in the book <br>'
	print '<hr', invertDict(tallyList())[1], 'Words that appear exactly once <hr>'
	print len(longWords()), 'Words that have longer than 15 characters <hr>'
	print 'list of the longest words: <br>' + str(longWords()) + '<hr>'
	commonWordsMain()

printWeb()
