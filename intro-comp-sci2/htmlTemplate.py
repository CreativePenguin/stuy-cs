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

def printWeb():
	print header
	#print css
	print headFoot
	#print bodyCode()
	print foot
printWeb()
