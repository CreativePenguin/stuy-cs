#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
cgitb.enable()

def makeHeader():
	a = '''<!DOCTYPE html>
<html>
	<head>
		<title>convertTable</title>
'''
	return a
def makeTable():
	a = '		<table>\n'
	a += makeTableHeader()
	a += makeTableBody()
	a += '		</table>'
	return a
def makeTableHeader():
	a = '			<tr>\n'
	heading = 'id,first_name,last_name,email,ip_address'
	for val in heading.split(','):
		a += '				<th> ' + val + ' </th>\n'
	a += '			</tr>\n'
	return a
def makeTableBody():
	val = ''
	info = '''
1,Franny,Vobes,fvobes0@prweb.com,160.238.25.191
2,Barthel,Ough,bough1@mail.ru,8.215.173.18
3,Crissy,Steagall,csteagall2@furl.net,87.29.11.55
4,Danny,Bartlosz,dbartlosz3@indiegogo.com,48.20.208.251
5,Flossie,Bruster,fbruster4@amazonaws.com,95.70.173.30
6,Simmonds,Coryndon,scoryndon5@meetup.com,43.211.172.60
7,Griffith,Mossbee,gmossbee6@ca.gov,31.226.71.188
8,Serena,Petranek,spetranek7@livejournal.com,128.224.182.13
9,Tirrell,Sellick,tsellick8@census.gov,47.5.73.120
10,Jess,Caulliere,jcaulliere9@istockphoto.com,87.206.223.153
11,Tonye,Haddrill,thaddrilla@disqus.com,224.7.243.118
12,Dillon,Gladhill,dgladhillb@cnn.com,183.251.76.53
13,Ursuline,Redemile,uredemilec@netscape.com,63.237.118.107
14,Aaren,Stanners,astannersd@fda.gov,172.151.43.226
15,Lorianne,Camden,lcamdene@bbc.co.uk,20.121.50.176
16,Bernadette,Emanuelov,bemanuelovf@ustream.tv,180.48.49.88
17,Hugibert,Fleckness,hflecknessg@so-net.ne.jp,168.230.209.177
18,Netta,Burkinshaw,nburkinshawh@parallels.com,145.166.79.150
19,Roley,Tollady,rtolladyi@omniture.com,69.120.30.138
20,Tommy,Cavee,tcaveej@google.nl,2.254.75.140'''
	for x in info.split('\n'):
		val += '			<tr>\n'
		for y in x.split(','):
			val += '				<td> ' + y + ' </td>\n'
		val += '			</tr>\n'
	return val
def makeFooter():
	print '''
	</body>
</html>'''
def makeFile():
	print makeHeader()
	print '''	</head>
	<body>'''
	print makeTable()
	print makeFooter()
makeFile()
