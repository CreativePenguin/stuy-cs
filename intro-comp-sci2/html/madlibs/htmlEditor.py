#!/user/bin/python
print "Content-type: text/html\n"
import cgitb
cgitb.enable()
import random
header = '''<!DOCTYPE html>
<html>
    <head>
    '''
footer = '''
    </body>
</html>'''
css = '''
    <style>
        .new {
            color: blue;
            font-side: 18;
            }
        body {
            background-color: #ccffff;
            color: gray;
            font-family: serif;
        }
    </style>
</head>
<body>
'''
excerpt1 = '''
Call me <span class = "new"> $PROPERNOUN$ </span>. Some <span class = "new"> $NOUN$ </span> ago- never mind how long precisely-having little or no money in my purse, and $NOUN$ particular to interest me on shore, I <span class = "new"> $VERB$ </span> I would <span class = "new"> $VERB$ </span> about a little and see the <span class = "new"> $ADJECTIVE$ </span> part of the world. It is a way I have of driving off the spleen and regulating the circulation. Whenever I find myself growing grim about the mouth; whenever it is a damp, <span class = "new"> $ADVERB$ $NOUN$ </span> in my soul; whenever I find myself involuntarily pausing before <span class = "new">  $NOUN$ </span> warehouses, and bringing up the rear of every funeral I meet; and especially whenever my hypos get such an upper hand of me, that it requires a strong moral principle to prevent me  from deliberately stepping into the street, and methodically knocking people's hats off- then, I account it high time to get to sea as soon as I can. This is my <span class = "new"> $NOUN$ </span> for pistol and ball.
'''
nouns = ['juniper','football','elderberries','pineapple','lamp']
pronouns = ['Sciborgs','Robowranglers','Stuypulse','Simbotics','Robonauts']
verbs = ['demolish','obliterate','flail','syncronize','synthesize']
adverbs = ['stupendously','horrendously','wishy-washy','quickly','commonly']
adjectives = ['corrupt','incorrigible','vile','repulsive','new']
def scanExcerpt():
    initial = excerpt1.split()
    i = 0
    while i < len(initial):
        if initial[i][0] == '$':
            if initial[i][1] == 'N':
                initial[i] = nouns[random.randint(0,4)]
            elif initial[i][1] == 'P':
                initial[i] = pronouns[random.randint(0,4)]
            elif initial[i][1] == 'V':
                initial[i] = verbs[random.randint(0,4)]
            elif initial[i][3] == 'V':
                initial[i] = adverbs[random.randint(0,4)]
            else:
                initial[i] = adjectives[random.randint(0,4)]
        i += 1
    return ' '.join(initial)
print header
print css
print scanExcerpt()
print footer
