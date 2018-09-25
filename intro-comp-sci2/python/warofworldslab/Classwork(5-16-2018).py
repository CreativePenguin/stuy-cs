#!/usr/bin/python
print "Content-type: text/html\n"
import cgitb
#cgitb.enable()

import string
file = open('warsmall.txt','r')



file = file.read()
if '\r\n' in file:
        print 'windows'
        file = file.replace('\r\n','\n')

def tally(l):
	val = {}
	for i in l:
		if i in val:
			val[i] = val[i] + 1
		else:
			val[i] = 1
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
	print len(file)
	
def lowercaseList():
	i = 0
	val = []
	#val = punctlessFile()
	while i < len(listFile()):
		val[i] = punctlessFile[i].lower()
		#print punctlessfile[i]
	return val
	
def tallyList():
        return tally(lowercaseList())

def uniqueWords():
        return len(tallyList())
        

#print listFile()
#print punctlessFile()
#print countCharacters()
#print lowercaseList()
print tallyList()
