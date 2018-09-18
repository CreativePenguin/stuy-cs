#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
import cgi
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

data = open('/home/support/konstans/public_html/pokedata/data.csv','r').read()
stats = open('/home/support/konstans/public_html/pokedata/stats.csv','r').read()
evolve = open('/home/support/konstans/public_html/pokedata/evolve.csv','r').read()
#data = open('data.csv','r').read()
#stats = open('stats.csv', 'r').read()
#evolve = open('evolve.csv', 'r').read()

def splitData(y):
	splitdata = y.split('\n')
	val = []
	for x in splitdata:
		val.append(x.split(','))
	val = val[:len(val) - 1]
	return val

def statsData():
	val = []
	listStat = splitData(stats)
	for x in listStat:
		atk = 'Attack: ' + str(x[3])
		dfns = 'Defense: ' + str(x[4])
		hp = 'Hit Points: ' + str(x[5])
		val.append(atk + '<br>' + dfns + '<br>' + hp + '<br>')
	return val

def cgiFieldStorageToDict():
   ans = {}
   for key in cgi.FieldStorage().keys():
     ans[ key ] = cgi.FieldStorage()[ key ].value
   return ans

def bodyCode():
	form = cgiFieldStorageToDict()
	if 'poke1' in form:
		print splitData(data)[1][int(form['poke1'])] + statsData()[int(form['poke1'])]
	if 'poke2' in form:
		print splitData(data)[1][int(form['poke2'])] + statsData()[int(form['poke2'])]

def printWeb():
	print header
	#print css
	print headFoot
	#print bodyCode()
	print foot
printWeb()
