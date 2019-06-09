# Take Home Exam (Jarair and Winston)

## 1) Voter Ballots -- Winston

#### (1A) Constructor

__voteCount: __
Takes the ballot list value parameter. There's an iterator that will go through
all the sets in the parameter, and another iterator that will go through all the
values in the set. Then, if it is a new value, a new key is added, with a value
of one. If the value is already in the set, then the key will be re-added with
a value one higher than the last

__maxValue:__
This value is supposed to keep track of which value the highest is, in order to
make maxVotes() O(1). The value will update when a key is added that is already
contained, and if this new addition makes the value higher than the maxvalue
variable, it will be updated

#### (1B) maxVotes()

As I didn't want to use an iterator to make it O(N), the maxvalue variable 
already exists from the last function. As a result, all this function does is 
return the value.

#### (1B) candidatesWithMost()

This just contains an iterator that goes through the keys of the map. At each
key, it will get the corresponding value, and check to see if the value is
equal to the maxVotes(). If it is, it will be added to the set that is
eventually returned as the result.

#### (1C) Time Complexity for candidatesWithMost() 

Assuming there are C candidates and V voters, the time complexity should be
O(C). It will go through the pre-generated map that keeps track of the votes
for each candidate, making it O(C), and then performs the O(1) procedure of
checking it with the maxVotes() function. However, the generating of the map
is O(C*V).

## 2) MorseCode -- (Winston)

#### Constructor

This is private to make a singleton class.

__morseAToZ:__
This holds the morse code for letters A to Z.

__englishAToZ:__
This holds the alphabet for letters A to Z.

__morseToEnglish:__
Uses the method listsToMap() to create a map from the morse values to english
values, using morse as keys

__englishToMorse:__
Uses the method listsToMap() to create a map from the english values to the
morse values, using english as keys

#### getInstance()

This is used to ensure that only one instance of the class can be created. It
checks to see if a previous instance of the class has already been created, by
checking if the instance variable is equal to null. If a previous instance
hasn't been created, it will create a new one, if not, it will just return the
instance already created.

#### listsToMap()

This method takes in two lists. It uses generics to ensure that they can be
lists of any type. The first thing it does is it makes sure that the two lists
are the same length, and throws an error if they're not. Then, it creates a new
Map, and inserts in all the values in both lists with an iterator. The first
parameter becomes the keys, and the second becomes the values.

#### readFile()

This method accepts a File type as an input. It uses the file to create an new
instance of a FileReader, which is used to create a new instance of
BufferedReader, as it is capable of reading lines. Then, I used try with
resources statement to avoid needing a close() statement. Inside the try
statement, I used a while loop to continue calling readLine until it was null.
Inside the while loop, I used the method readLine() to convert each letter to
morse/english.

### readLine()

This method accepts a string as an input. It first checks to see if it is morse
or english by checking to see if the first letter is an english character or a
morse character. Then, it splits the input based into its individual letters.
Then it creates a variable to store the converted value. Then, it iterates
through the list, and converts each of its values. If the value is not found in
the map, then it is just transferred directly (this is for spaces). All english
is converted to uppercase. Then it returns the variable.

### run()

This will just print out a statement, asking the user to input the line. It
uses a scanner to store their input, and uses readLine() to convert their
input. After converting the input, it prints it.

## 3) Jumping Leprechauns -- Jarair

When you run the program, you will first be prompted to enter the number of leprechauns you want to use in the simulation (the N value). Then, you will be prompted to enter how many simulations you want. After this, the simulation would occur and you will have the option of seeing your results. Type either Yes or No for this prompt. If you type Yes, your results  will be displayed by leprechaun number, and will show the end distance and gold of each leprechaun. 
