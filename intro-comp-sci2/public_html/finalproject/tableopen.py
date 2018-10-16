#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
cgitb.enable()

import cgi
import string

#returns a list of lists
def openFile(datapage):
    file = open(datapage,"r")
    file = file.read()
    filelist = file.split('\n')
    listoflist = []
    for row in filelist:
        listoflist.append(row.split(','))
    return listoflist

#creates a table from a string
def makeHtml(function):
    main = '<table border = 1>'
    main += makeHead()
    main += function
    main += '</table>'
    return main

#list of colors used to represent crimes
def crimeColor():
    val = ['LightBlue','LightCoral','LightCyan','LightGray','LightSkyBlue','LightYellow','LightPink']
    val += ['Thistle','PaleGreen','PaleGoldenRod','PeachPuff','LavenderBlush']
    return val

#list of table headings
def headingNames():
    return ['ID','Case Number','Date','Block','IUCR','Crime','Description','Location','Arrest?','Domestic?','Beat','District','Ward','Community Area','FBI Code','Year','Updated On','Coordinate']

#List of crimes that can be selected
def crimeFormOptions():
    val = ['ALL','BATTERY','ROBBERY','ASSAULT','NARCOTICS','CRIMINAL DAMAGE','WEAPONS VIOLATION','THEFT']
    val += ['DECEPTIVE PRACTICE','CRIMINAL TRESSPASS','PROSTITUTION','BURGLARY','ARRESTS ONLY','DOMESTIC CRIMES ONLY']
    return val

def makeheader(header):
    return "<th>" + header + "</th>"

def makedata(data):
    return "<td>" + data + "</td>"

#makes the heading portion of the code
def makeHead():
    head = '<tr>'
    for each in headingNames():
        head += makeheader(each)
    head += '</tr>'
    return head

#Form stuff
def cgiFieldStorageToDict(fieldStorage):
   ans = {}
   for key in fieldStorage.keys():
     ans[ key ] = fieldStorage[ key ].value
   return ans

#relays radio button results
def cssFormChooser():
    form = cgiFieldStorageToDict(cgi.FieldStorage())
    if 'color' in form:
        color = form['color']
    else:
        color = 'crime'
    return color

#returns proper color based on the table data and the form
def colorTranslator(crime,arrest,domestic,option):
    if option == 'crime':
        i = 0
        while i < len(crimeFormOptions()):
            if crime == crimeFormOptions()[i]:
                return crimeColor()[i]
            i += 1
        return 'Ivory'
    if option == 'arrest':
        return domesticAndArrestColor(arrest)
    if option == 'domestic':
        return domesticAndArrestColor(domestic)
    else:
        return 'white'

#helper function for the last one (bc I was lazy)
def domesticAndArrestColor(val):
    if val == 'TRUE':
        return 'PaleGreen'
    else:
        return 'LightCoral'

#makes the actual form
def formCreate():
    form = '''<form method="GET" action="tableopen.py">'''
    form += crimeForm() + '<br>' + colorForm() + "<br>"
    form += '''<input type="submit" name="done" value="Check Data">'''
    return form

def optionListTemplate(title,name,options):
    form = title + '<br> <select name = "'+ name +'" size = "1">'
    for i in options:
        form += '<option>' + str(i) + '</option>' + '\n'
    form += '</select>'
    return form

def crimeForm():
    return optionListTemplate('Filter By Crime:','crime',crimeFormOptions())

#The segway between the form and real things happening
def formChoose():
    form = cgiFieldStorageToDict(cgi.FieldStorage())
    crime = "ALL"
    if "crime" in form:
        crime = form["crime"]
    for x in crimeFormOptions():
        if crime == 'ALL':
            return makeHtml(makebody('ChicagoCrimes.csv'))
        if crime == 'ARRESTS ONLY':
            return makeHtml(make1only(8,'ChicagoCrimes.csv'))
        if crime == 'DOMESTIC CRIMES ONLY':
            return makeHtml(make1only(9,'ChicagoCrimes.csv'))
        if crime == x:
            return makeHtml(make1crime(x,'ChicagoCrimes.csv'))
        else:    
            return makeHtml(makebody('ChicagoCrimes.csv'))

def colorForm():
    return '''Pick Color Filter: <br>
<input type="radio" name="color" value="crime" checked> Crime
<input type="radio" name="color" value="arrest"> Arrest
<input type="radio" name="color" value="domestic"> Domestic'''

#Tables created by the forms
def make1crime(crime,datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        if row[5] == crime:
            data += '\n<tr style = \"background-color:' + colorTranslator(row[5],row[8],row[9],cssFormChooser()) + '\">'
            data += makedata(row[0])
            data += makedata(row[1])
            data += makedata(row[2])
            data += makedata(row[3])
            data += makedata(row[4])
            data += makedata(row[5])
            data += makedata(row[6])
            data += makedata(row[7])
            data += makedata(row[8])
            data += makedata(row[9])
            data += makedata(row[10])
            data += makedata(row[11])
            data += makedata(row[12])
            data += makedata(row[13])
            data += makedata(row[14])
            data += makedata(row[17])
            data += makedata(row[18])
            data += makedata(row[19]+row[20])
            data += '</tr>'
        x += 1
    return data

def make1only(variable, datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        if row[variable] == "TRUE":
            data += '<tr style = \"background-color:' + colorTranslator(row[5],row[8],row[9],cssFormChooser()) + '\">'
            data += makedata(row[0])
            data += makedata(row[1])
            data += makedata(row[2])
            data += makedata(row[3])
            data += makedata(row[4])
            data += makedata(row[5])
            data += makedata(row[6])
            data += makedata(row[7])
            data += makedata(row[8])
            data += makedata(row[9])
            data += makedata(row[10])
            data += makedata(row[11])
            data += makedata(row[12])
            data += makedata(row[13])
            data += makedata(row[14])
            data += makedata(row[17])
            data += makedata(row[18])
            data += makedata(row[19]+row[20])
            data += '</tr>'
        x += 1
    return data

def makebody(datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        data += '\n<tr style = \"background-color:' + colorTranslator(row[5],row[8],row[9],cssFormChooser()) + '\">'
        data += makedata(row[0])
        data += makedata(row[1])
        data += makedata(row[2])
        data += makedata(row[3])
        data += makedata(row[4])
        data += makedata(row[5])
        data += makedata(row[6])
        if row[7] == '"SCHOOL':
            data += makedata(row[7]+row[8]+row[9])
            data += makedata(row[10])
            data += makedata(row[11])
            data += makedata(row[12])
            data += makedata(row[13])
            data += makedata(row[14])
            data += makedata(row[15])
            data += makedata(row[16])
            data += makedata(row[19])
            data += makedata(row[20])
            data += makedata(row[21]+row[22])
        else:
            data += makedata(row[7])
            data += makedata(row[8])
            data += makedata(row[9])
            data += makedata(row[10])
            data += makedata(row[11])
            data += makedata(row[12])
            data += makedata(row[13])
            data += makedata(row[14])
            data += makedata(row[17])
            data += makedata(row[18])
            data += makedata(row[19]+row[20])
        data += '</tr>\n'
        x += 1
    return data

makebody('ChicagoCrimes.csv')

def makeWebsite(datapage):
    header = '''<html>
    <body>
        <title> Crime Statistics </title>
            <h1> Chicago Crime Records </h1>'''
    body = formCreate()
    body += formChoose()
    bottom = '''    </body>
<html>'''
    return header + body + bottom

print makeWebsite("ChicagoCrimes.csv")