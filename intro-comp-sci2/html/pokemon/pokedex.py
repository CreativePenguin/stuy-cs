#!/usr/bin/python
print "Content-type: text/html\n"
import cgitb
import random
cgitb.enable()

header = '''<!DOCTYPE html>
<html>
	<head>
		<title> Pokedata </title>'''

css = '''		<style>
				th {
					background-color: blue;
					color: white;
				}
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

def extendedList():
	val = splitData(data)
	evolveData = splitData(evolve)
	for x in range(len(splitData(data))):
		val[x][0] = numToID(val[x][0])
		val[x].append(imgConvert(x))
		val[x].append(evolveData[x][1])
	i = 0
	for x in evolvesToList():
		val[i].append(x)
		i += 1
	for x in range(len(splitData(data))):
		val[x].append(statsData()[x])
	val[0][8] = 'image'
	val[0][9] = 'Evolves From'
	val[0][10] = 'Evolves To'
	val[0][11] = 'stats'
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

def typesData():
	val = splitData(stats)
	for x in val:
		if x[2] == 'NA':
			x.append(str(x[1]))
		else:
			x.append(str(x[1]) + '<br>' + str(x[2]))
	val[0][12] = 'types'
	return val

def evolvesToList():
	val = []
	for x in range(301):
		val.append('NA')
	#return val
	for x in range(300):
		if splitData(evolve)[x][1] == 'NA':
			val[x] = 'NA'
		elif splitData(evolve)[x][1] == 'evolves_from_species_id':
			val[x] = 'NA'
		else:
			basic = int(splitData(evolve)[x][1])
			if basic < 300:
				val[basic] = idToPokemon(x)
	return val

def idToPokemon(num):
	val = str(num)
	if num == 0:
		return 'name'
	if val == 'NA':
		return 'NA'
	if val == 'evolves_from_species_id':
		return 'Evolves To'
	else:
		return splitData(data)[num][1]

def numToID(x):
	if x < 10:
		return '00' + str(x)
	elif x < 100:
		return '0' + str(x)
	else:
		return str(x)

def imgConvert(x):
	val = numToID(x)
	returnval = '<img src = \"http://marge.stuy.edu/~konstans/pokedata/' + val
	returnval += '.png\" style=\"width:100px;height:100px;\">'
	return returnval

def part1():
	val = splitData(data)
	for x in range(len(val)):
		val[x] = val[x][:5]
		val[x][2] = val[x][1].capitalize()
		val[x][1] = imgConvert(x)
	val[0][0] = 'ID'
	val[0][1] = 'image'
	val[0][2] = 'name'
	return val

def part2():
	val = extendedList()
	for x in range(len(val)):
		val[x] = val[x][:1] + [val[x][8]] + [idToPokemon(x)] + val[x][3:5] + val[x][9:11]
	return val

def part3():
	val = extendedList()
	for x in range(len(val)):
		val[x] = val[x][:1] + [val[x][8]] + [idToPokemon(x)] + val[x][3:5] + val[x][9:11] + [val[x][11]]
	return val

def coolStats():
	val = typesData()
	for x in range(len(val)):
		val[x] = val[x][3:6] + [val[x][12]]
	return val
'''
def part4():
	rand = random.randint(1,300)
'''
def tableMain(data):
	print '''
			<table>
				<tr>'''
	tableHeader(data)
	tableBody(data)
	print '			</table>'

def tableHeader(data):
	for x in data[0]:
		print '					<th>' + x + ' </th>'
	print '				</tr>'

def tableBody(data):
	for x in data[1:]:
		print '				<tr>'
		for i in x:
			print '					<td>' + i + ' </td>'
		print '				</tr>'

def bodyCode():
	print '<button type=\"button\" onclick=\"<p>test</p>\">Test</button>'
	print 'Part 1 Table'
	tableMain(part1())
	print 'Part 2 Table'
	tableMain(part2())
	print 'Part 3 Table'
	tableMain(part3())

def printWeb():
	print header
	print css
	print headFoot
	bodyCode()
	print foot
printWeb()
#print coolStats()
#print tableMain(splitData(stats))