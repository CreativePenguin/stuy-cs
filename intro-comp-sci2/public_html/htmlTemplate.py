#!/usr/bin/python
print 'Content-type: text\html/n'
import cgitb
cgitb.enable()

def header():
	return '''<!DOCTYPE html>
<html>
	<head>
		<title> Nonexistent </title>'''

def css():
	return '''		<style>
			//css goes here
		</style>
'''
		
def headFoot():
    return '''	</head>
	<body>'''
	
def foot():
    return '''	</body>
</html>'''

def printWeb():
	print header()
	#print css()
	print headFoot()
	#bodyCode()
	print foot()
printWeb()
