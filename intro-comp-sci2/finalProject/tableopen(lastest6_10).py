#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
cgitb.enable()

import cgi

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

def makeheader(header):
    return "<th>" + header + "</th>"

def makedata(data):
    return "<td>" + data + "</td>"

def makeHead():
    head = '<tr>'
    head += makeheader('ID')
    head += makeheader('Case Number')
    head += makeheader('Date')
    head += makeheader('Block')
    head += makeheader('IUCR')
    head += makeheader('Crime')
    head += makeheader('Description')
    head += makeheader('Location')
    head += makeheader('Arrest?')
    head += makeheader('Domestic?')
    head += makeheader('Beat')
    head += makeheader('District')
    head += makeheader('Ward')
    head += makeheader('Community Area')
    head += makeheader('FBI Code')
    head += makeheader('Year')
    head += makeheader('Updated On')
    head += makeheader('Coordinate')
    head += '</tr>'
    return head

#for the ALL table
def makebody(datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        data += '<tr>'
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
        data += '</tr>'
        x += 1
    return data

#For the form, a table with 1 crime only
def make1crime(crime,datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        if row[5] == crime:
            data += '<tr>'
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

#for arrests and domestic crimes
def make1only(variable, datapage):
    datalist = openFile(datapage)
    data = ""
    x = 1
    while x < len(datalist)-1:
        row = datalist[x]
        if row[variable] == "TRUE":
            data += '<tr>'
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

#form stuff
def formCreate():
    form = '''<form method="GET" action="tableopen.py">'''
    form += makeOnlyForm() + "<br>"
    form += '''<input type="submit" name="done" value="Check Data">'''
    return form

def makeOnlyForm():
    form = '''Show Only: <br> <select name="crime" size ="1">
        <option>ALL</option>
        <option>BATTERY</option>
        <option>ROBBERY</option>
        <option>ASSAULT</option>
        <option>NARCOTICS</option>
        <option>CRIMINAL DAMAGE</option>
        <option>WEAPONS VIOLATION</option>
        <option>THEFT</option>
        <option>DECEPTIVE PRACTICE</option>
        <option>CRIMINAL TRESPASS</option>
        <option>PROSTITUTION</option>
        <option>BURGLARY</option>
		<option>ARRESTS ONLY</option>
		<option>DOMESTIC CRIMES ONLY</option>
    </select>'''
    return form

def formChoose():
    form = cgiFieldStorageToDict(cgi.FieldStorage())
    crime = "ALL"
    if "crime" in form:
        crime = form["crime"]
    if crime == "ALL":
        return makeHtml(makebody("ChicagoCrimes.csv"))
    if crime == "BATTERY":
        return makeHtml(make1crime("BATTERY","ChicagoCrimes.csv"))
    if crime == "ROBBERY":
        return makeHtml(make1crime("ROBBERY","ChicagoCrimes.csv"))
    if crime == "ASSAULT":
        return makeHtml(make1crime("ASSAULT","ChicagoCrimes.csv"))
    if crime == "NARCOTICS":
        return makeHtml(make1crime("NARCOTICS","ChicagoCrimes.csv"))
    if crime == "CRIMINAL DAMAGE":
        return makeHtml(make1crime("CRIMINAL DAMAGE","ChicagoCrimes.csv"))
    if crime == "WEAPONS VIOLATION":
        return makeHtml(make1crime("WEAPONS VIOLATION","ChicagoCrimes.csv"))
    if crime == "THEFT":
        return makeHtml(make1crime("THEFT","ChicagoCrimes.csv"))
    if crime == "DECEPTIVE PRACTICE":
        return makeHtml(make1crime("DECEPTIVE PRACTICE","ChicagoCrimes.csv"))
    if crime == "CRIMINAL TRESPASS":
        return makeHtml(make1crime("CRIMINAL TRESPASS","ChicagoCrimes.csv"))
    if crime == "PROSTITUTION":
        return makeHtml(make1crime("PROSTITUTION","ChicagoCrimes.csv"))
    if crime == "BURGLARY":
        return makeHtml(make1crime("BURGLARY","ChicagoCrimes.csv"))
    if crime == "ARRESTS ONLY":
        return makeHtml(make1only(8,"ChicagoCrimes.csv"))
    if crime == "DOMESTIC CRIMES ONLY":
        return makeHtml(make1only(9,"ChicagoCrimes.csv"))
    return makeHtml(makebody("ChicagoCrimes.csv"))

def cgiFieldStorageToDict(fieldStorage):
   ans = {}
   for key in fieldStorage.keys():
     ans[ key ] = fieldStorage[ key ].value
   return ans

#final function
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

