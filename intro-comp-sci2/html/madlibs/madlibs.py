#!/user/bin/python
print "Content-type: text/html\n"
#import cgitb
#cgitb.enable()
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

nouns = ['advice', 'airplane', 'alcohol', 'alien', 'aluminum', 'ambigram', 'ambulance', 'ant', 'apple', 'aquarium', 'astrophysicist', 'athlete', 'avocado', 'ball', 'banana', 'barnacle', 'baseball', 'battleship', 'bear', 'bed', 'binder', 'bird', 'blueberry', 'bluejay', 'books', 'bookshelf', 'bowl', 'brouhaha', 'building', 'burger', 'bus', 'butterbeer', 'cadet', 'calendar', 'calculator', 'calculus', 'calculus', 'camera', 'candle', 'candy', 'canine', 'car', 'carnival', 'carpet', 'carrot', 'cat', 'cat', 'cheek', 'cheetah', 'chemistry', 'chicken', 'chocolate', 'chopsticks', 'chrome', 'clout', 'clown', 'comma', 'computer', 'concrete', 'congressman', 'conniption', 'consanguinity', 'conundrum', 'cornucopia', 'couch', 'cow', 'cracker', 'crown', 'cryptocurrency', 'customer', 'death', 'defibrillator', 'deodorant', 'dilemma', 'dinosaur', 'discord', 'disease', 'dog', 'dolphin', 'doorknob', 'dragon', 'duck', 'dust', 'bunny', 'dynasty', 'ease', 'eigenvector', 'elderberries', 'elephant', 'elevator', 'engineer', 'ennui', 'epidemiologist', 'exhibition', 'eyeball', 'fairy', 'fern', 'flower', 'flower', 'flute', 'food', 'foot', 'fox', 'fuddy-duddy', 'gazebo', 'gazelle', 'geodesic', 'giant', 'giraffe', 'girth', 'grades', 'grandma', 'half-and-half', 'hallway', 'headache', 'headsets', 'health', 'heirloom', 'helicopter', 'home', 'hunger', 'iamb', 'ice', 'island', 'isopropyl-alcohol', 'jelly', 'kerfuffle', 'king', 'lab', 'ladder', 'letter', 'macrology', 'loophole', 'lotion', 'love', 'machine', 'magician', 'mars', 'mirage', 'mirror', 'mouse', 'muffin', 'muggle', 'mullet', 'normie', 'nose', 'notebook', 'novel', 'oreos', 'organ', 'ostrich', 'palace', 'panda', 'paper', 'park', 'pear', 'pedigree', 'pencil', 'penguin', 'peregrine', 'falcon', 'person', 'person', 'pillow', 'pillow', 'pineapple', 'pirate', 'plant', 'podcast', 'poetry', 'poster', 'potato', 'projector', 'puppy', 'quail', 'question', 'rack', 'rice', 'river', 'rock', 'sacrifice', 'saddle', 'saiyan', 'sculpture', 'sharpener', 'shibboleth', 'sloth', 'snail', 'spaghetti', 'student', 'subway', 'summit', 'sun', 'sushi', 'table', 'tardis', 'thunder', 'tiger', 'time', 'toddler', 'tomato', 'tongue', 'train', 'treaty', 'tree', 'turtle', 'vapor', 'violet', 'vision', 'wolverine', 'word', 'xebec', 'zither', 'zombie']

#YOU NEED TO BREAK UP THE LIST OF VERBS - some are transitive, some require prepositions afterwards, and some are normal.
verbs = ['accumulates', 'adheres', 'affirms', 'aggregates', 'aids', 'amalgamates', 'assumes', 'attacks', 'bakes', 'baking', 'beckons', 'beholds', 'bellows', 'bolsters', 'breathes', 'breathes', 'browses', 'bulldozes', 'calls', 'calls', 'carries', 'catapults', 'catches', 'cheats', 'chops', 'chucks', 'cleans', 'clips', 'codes', 'constructs', 'creates', 'cries', 'cries', 'crush', 'crying', 'crystallizes', 'cuts', 'dabs', 'dance', 'dances', 'dances', 'dances', 'dashes', 'deceives', 'degusts', 'demands', 'deplores', 'destroys', 'deters', 'dies', 'dies', 'dodges', 'does', 'dozes', 'drink', 'drinks', 'drops', 'eat', 'eating', 'eats', 'eats', 'embark', 'enters', 'escapes', 'executes', 'exemplifies', 'falls', 'falls', 'fears', 'feeds', 'finishes', 'flails', 'flicks', 'flies', 'flies', 'floats', 'flushes', 'flying', 'flys', 'folds', 'follows', 'fosters', 'frolics', 'gallops', 'gathers', 'gives', 'goes', 'golfs', 'hacks', 'hates', 'hits', 'hits', 'holds', 'illuminates', 'inhales', 'interferes', 'invents', 'irritates', 'jettisons', 'jogs', 'jumps', 'kneels', 'kraal', 'leaps', 'licks', 'listens', 'lists', 'lives', 'lounging', 'mars', 'materializes', 'meanders', 'mines', 'mitigates', 'motivates', 'mourns', 'moves', 'naps', 'obtains', 'passes', 'perambulates', 'peruses', 'placates', 'plays', 'plays', 'plunges', 'ponders', 'pours', 'promises', 'pulls', 'push', 'racewalks', 'radiates', 'raids', 'reading', 'reclines', 'recycles', 'reduces', 'reuses', 'rotates', 'ruminates', 'runs', 'runs', 'rustles', 'saunters', 'scares', 'scaring', 'screams', 'screams', 'searches', 'shouts', 'sings', 'sinking', 'skedaddles', 'skips', 'slaps', 'slaps', 'sleep', 'sleeps', 'sleeps', 'slumbers', 'slurps', 'smells', 'smile', 'smiling', 'smirks', 'snorkels', 'soaks', 'speaks', 'splats', 'sprints', 'squanders', 'submits', 'survives', 'swim', 'swims', 'swims', 'tantalizes', 'taste', 'tenses', 'thinks', 'thinks', 'throws', 'throws', 'tries', 'tries', 'trudges', 'tumbles', 'types', 'vomits', 'votes', 'waddles', 'walks', 'want', 'whispers', 'win', 'works', 'writes', 'yeets', 'zip-lines']

adjectives = ['abominable', 'admirable', 'aggressive', 'alarming', 'amazing', 'ambiguous', 'angry', 'annoying', 'annoying', 'antibiotic', 'antidisestablishmentarian', 'arrogant', 'authentic', 'bald', 'barbarous', 'bawdy', 'beautiful', 'beautiful', 'bereft', 'bereft', 'big', 'big', 'bilious', 'bludgeoned', 'blue', 'boring', 'brackish', 'brash', 'brave', 'bright', 'broken', 'brown', 'calamitous', 'calm', 'chaotic', 'charismatic', 'cheerful', 'chunky', 'cloudy', 'colorful', 'comely', 'confused', 'confuzzle', 'cool', 'cordial', 'coriacious', 'corrosive', 'coy', 'crazy', 'creepy', 'crimson', 'crispy', 'cruel', 'cumbersome', 'dangerous', 'dank', 'dead', 'dead', 'deafening', 'delicious', 'delightful', 'deplorable', 'depressed', 'difficult', 'diffident', 'dim', 'diminutive', 'diplomatic', 'discombobulated', 'disgusting', 'distorted', 'dizzy', 'draconian', 'dreamy', 'drumpf', 'dumb', 'dummy', 'eager', 'ecstatic', 'egregious', 'evanescent', 'excited', 'exhilarating', 'exquisite', 'extra', 'extravagant', 'exuberant', 'exuberant', 'fast', 'fast', 'fire-breathing', 'firm', 'first', 'flaccid', 'flimsy', 'flippant', 'fluffy', 'fluffy', 'forlorn', 'fragile', 'free', 'fresh', 'frustrating', 'funny', 'gargantuan', 'giant', 'glib', 'gothic', 'grandiose', 'green', 'happy', 'hard', 'hedonistic', 'heroic', 'hostile', 'hot', 'huge', 'huge', 'impromptu', 'inexpensive', 'innocent', 'insensitive', 'interesting', 'interesting', 'invincible', 'jarring', 'jolly', 'kafkaesque', 'languid', 'late', 'lazy', 'long', 'loquacious', 'lucky', 'ludicrous', 'mammoth', 'maniacal', 'melodic', 'moist', 'mouthwatering', 'muscular', 'mystic', 'neutral', 'nice', 'non-offensive', 'normal', 'obsequious', 'obtuse', 'odd', 'Orwellian', 'pale', 'partitioned', 'petulant', 'possessive', 'practical', 'proactive', 'quadripartite', 'quick', 'random', 'rare', 'red', 'red', 'regretful', 'repulsive', 'resonant', 'reverent', 'romanized', 'rotten', 'rubiginous', 'rustic', 'sad', 'salty', 'satanic', 'scruffy', 'scrumptious', 'scrumptious', 'serendipitous', 'shiny', 'short', 'silent', 'sketchy', 'slow', 'slow', 'small', 'smart', 'soft', 'sore', 'sparkling', 'sparkly', 'spicy', 'squishy', 'stinky', 'strenuous', 'strong', 'stupendous', 'stupendous', 'successful', 'supercalifragilisticexpialidocious', 'surreal', 'surrounded', 'swanky', 'sweaty', 'swift', 'taboo', 'tacky', 'tall', 'tasty', 'tenacious', 'tiny', 'tired', 'unladen', 'upset', 'useful', 'vast', 'venomous', 'voracious', 'wet', 'wild', 'wonderful', 'zany', 'zealous', 'zoophagous']

adverbs = ['inadvertently', 'abnormally', 'above', 'abruptly', 'absentmindedly', 'across', 'afterwards', 'always', 'amazingly', 'angrily', 'anxiously', 'bashfully', 'beautifully', 'because', 'below', 'boldly', 'brilliant', 'brutally', 'cagily', 'calmly', 'carefully', 'cautiously', 'childishly', 'cleverly', 'coaxingly', 'continuously', 'cooly', 'courageously', 'cowardly', 'crazily', 'deadly', 'deliberately', 'desperately', 'diminishingly', 'dramatically', 'dreadfully', 'early', 'elegantly', 'endlessly', 'endlessly', 'enjoyably', 'enthusiastically', 'erroneously', 'esoterically', 'especially', 'eternally', 'everywhere', 'excruciatingly', 'expeditiously', 'flagrantly', 'frankly', 'frantically', 'frenetically', 'funnily', 'gently', 'genuinely', 'gingerly', 'grotesquely', 'haphazardly', 'happily', 'hastily', 'helplessly', 'hilariously', 'honestly', 'hurriedly', 'idyllically', 'immaculately', 'impatiently', 'impressively', 'incompetently', 'indubitably', 'inquisitively', 'instantly', 'interestingly', 'jauntily', 'jubilantly', 'justly', 'keenly', 'kindly', 'kindly', 'lasciviously', 'lastly', 'lazily', 'lazily', 'lifelessly', 'lightly', 'loftily', 'loudly', 'lovely', 'luckily', 'majestically', 'meaningfully', 'mysteriously', 'nervously', 'nervously', 'occasionally', 'onwards', 'optimistically', 'optimistically', 'painfully', 'pathetically', 'powerfully', 'precariously', 'presently', 'properly', 'quaintly', 'queasily', 'quickly', 'quickly', 'quickly', 'quickly', 'quickly', 'quickly', 'quickly', 'quietly', 'randomly', 'rapidly', 'really', 'recklessly', 'regretfully', 'regularly', 'rhapsodically', 'roughly', 'sadly', 'salaciously', 'scarcely', 'secretively', 'sedately', 'selfishly', 'serendipitously', 'sheepishly', 'shortly', 'shrewdly', 'silently', 'silently', 'sloppily', 'slowly', 'slowly', 'slowly', 'slowly', 'slowly', 'slowly', 'sluggishly', 'slyly', 'smoothly', 'solemnly', 'sorrowfully', 'speedily', 'steadily', 'stealthily', 'strongly', 'studiously', 'stupidly', 'suddenly', 'surprisingly', 'sweetly', 'swiftly', 'swimmingly', 'terribly', 'terribly', 'there', 'thoroughly', 'tiredly', 'tomorrow', 'tremulously', 'trickily', 'triumphantly', 'truthfully', 'unbearably', 'underground', 'unenthusiastically', 'unfortunately', 'unpredictably', 'unquestionably', 'violently', 'wearily', 'wickedly', 'wildly', 'zealously']

books = ['alice.txt','bravenewworld.txt','dorian.txt']
poems = ['treasureIsland.txt','mask.txt']
booknum = random.randint(0,2)
poemnum = random.randint(0,1)
book = open(books[booknum],"r").read()
poem = open(poems[poemnum],'r').read()
bookHeader = ['Alice In Wonderland','Brave New World','Picture of Dorian Gray']
poemHeader = ['Treasure Island','We Wear The Mask']

def bookToHtml():
	#initial = '\n</p>\n<p>\n'.join(book.split('\n'))
    initial = book.split(' ')
    i = 0
    while i < len(initial):
        if initial[i][0] == '$':
			if initial[i][1] == 'N':
				initial[i] = '<b> ' + nouns[random.randint(0,213)] + ' </b>'
			elif initial[i][1] == 'P':
				initial[i] = '<b> ' + pronouns[random.randint(0,4)] + ' </b>'
			elif initial[i][1] == 'V':
				initial[i] = '<b> ' + verbs[random.randint(0,199)] + ' </b>'
			elif initial[i][3] == 'V':
				initial[i] = '<b> ' + adverbs[random.randint(0,178)] + ' </b>'
			else:
				initial[i] = '<b> ' + adjectives[random.randint(0,221)] + ' </b>'
        i += 1
	val = ' '.join(initial)
    val = val.split('\n')
    while i < len(val):
        val[i] = '\n<p>\n' + val[i] + '\n</p>\n'
    return '<h1>' + bookHeader[booknum] + '</h1>' + ' '.join(val)
#def poemToHtml():

def printWebsite():
	print header
	print css
	print bookToHtml()
	print footer
printWebsite()
