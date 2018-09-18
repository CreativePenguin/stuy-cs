#!/usr/bin/python
print "Content-type: text/html\n"

#help you see errors
import cgitb
cgitb.enable()

#these 3 lines are important

#matplotlib allows you to use the graphing tools on a web server

#the Agg line is required to work without a graphical desktop (running on a remote computer)

import matplotlib
matplotlib.use("Agg")

import matplotlib.pyplot as plt

def main():
        x=[0,1,2,3,4] 
        y=[0,3,5,9,3]
        plt.plot(x,y) 
        plt.savefig("img/graph.png")

        plt.clf() #clear the figure after saving!

        
        x = [0.1,0.2,0.1,0.3,0.9]
        y = [0.9,0.4,0.2,0.5,0.2]
        plt.scatter(x, y,  alpha=0.5)
        plt.savefig("img/graph2.png")

        print "Done!<br>"
        print "Image?<br>"
        print '<img src="img/graph.png">'
        print "Another Image!<br>"
        print '<img src="img/graph2.png">'




head = '''<!DOCTYPE html>
<html>
  <head>
   <title>Demo!</title>
   
  </head>

  <body>'''

print head

#main will print things
main()

print ''' </body> 
</html>'''