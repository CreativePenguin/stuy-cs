#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
cgitb.enable()

header = '''<!DOCTYPE html>
<html>
	<head>
		<title> It doesn't matter </title>'''

css = '''		<style>
			//css goes here
		</style>
'''

headFoot = '''	</head>
	<body>'''

foot = '''	</body>
</html>'''

data = open('MOCK_DATA.csv','r').read()

def bodyCode():
	val = 'Average Shoe Size: ' + str(avgcol(dataList()[1:],3)) + ' <br>'
	val += 'Average Height: ' + str(avgcol(dataList()[1:],4)) + ' <br> <br>'
	val += '		<table>\n'
	for x in newData().split('\n'):
		val += '			<tr>\n'
		for y in x.split(','):
			val += '				<td> ' + y + ' </td>\n'
		val += '			</tr>\n'
	val += '		</table>\n'
	return val

def dataList():
	val = []
	for x in data.split('\n'):
		val += [x.split(',')]
	i = 0
	while i < len(val):
		if [''] in val:
			val.remove([''])
		i += 1
	return val

#print dataList()

def sumcol(table,col):
	val = 0
	i = 0
	while i < len(table):
		val += int(table[i][col])
		#print table[i][0],table[i][col]
		i += 1
	return val

#print sumcol(dataList()[1:],3)

def avgcol(table,col):
	return sumcol(table,col) / len(table)

#print avgcol(dataList()[1:],3)

def lastcol():
	val = dataList()
	val[0][5] = 'height:shoe size'
	i = 1
	while i < len(dataList()):
		val[i][5] = str(float(dataList()[i][4]) / float(dataList()[i][3]))
		i += 1
	return val

#print lastcol()

def newData():
	i = 0
	val = ''
	#val = '\n'.join(lastcol())
	while i < len(lastcol()):
		val += ','.join(lastcol()[i]) + '\n'
		i += 1
	return val

#print data
#print 'done'
#print newData()
#print lastcol()

def printWeb():
	print header
	#print css
	print headFoot
	print bodyCode()
	print foot
printWeb()
