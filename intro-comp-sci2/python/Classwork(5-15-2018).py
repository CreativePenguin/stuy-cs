def makeDictFromCSV(s):
	li = s.split('\n')
	fin = []
	val = {}
	for i in li:
		fin += [i.split(',')]
	for a in fin:
		val[a[0]] = a[1]
	return val
	
def tally(l):
	val = {}
	for i in l:
		if i in val:
			val[i] += 1
		else:
			val[i] = 1
	return val
'''	
print makeDictFromCSV("""a,3
b,4
c,6
d,10
f,9
a,99
b,0""")
'''
print tally( [ 'a', 'b', 'c', 'a', 'fish', 'b', 'a']) 
print tally( ['one','1','ONE','two','two','2',
        '2','oNe','3','3','ONe','uno','3'])
