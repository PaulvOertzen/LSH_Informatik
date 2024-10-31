# Documentation
This File is for documenting our code and the changes we have applied to it. 

## Structure and Designdecisions 
1: I have decided to not comment the code, since everything will be explained in this documentation.
2: I have divided this program into two class, one that does everything text-related and one that does
everything player-related
3: Instead of comparing the positions of player1 and player2 after one move, I decided to log the positions of each player into an
arraylist and compare them once one player jumpes out of the text. This has two advantages. First, the program is much faster,
because you do not need to compare after each move but just compare them at the end. And second of all, we can detect intersections 
even if the two players do not jump over the same characters at the same time.  

## Variables  
In this section I will briefly explain all the variables.
As general rule, I defined alle the variables to the smallest scope possible.

### textString 
A variable that contains the text which the user want's to be analyzed.  
### textLength
Contains the length of the Text 
### intersection 
Specific point in text where an intersection happened. 
The Value of this variable is used to put a marking into the text.
### stringIndexOutOfBounds
Is used to stop the game and continue with the next step, once the end of a given text is reached.
### map
Contains the hoppingdistances for each character. Logically, the characters are the 'key'
### player1Position / player2Position
Used to initialize the starting position's and track the positions throughout the game.
### positionPlayer1Array / positionPlayer2Array
Each position is written into this array. Those positions are used to determine if there is 
an intersection or not
### inputtext / rawtext 
Each line of text from the .txt file (inputfile) gets written in there and then passed 
into the rawtext variable and further on into textString and then returned to the globally 
defined variable
### positionPlayer1ArrayLength
Contains the size of the Arraylist where the positions from player 1 get stored in
(Further explanation in "Methods")
###  

## Classes and Methods

###  Class: Main
The Main class is simply just for the Compiler to have an entry-point.

### Class: Control 
This class does everything that has to do with reading, writing and manipulating texts.

#### Method: fillHashMap
This method fills the Hashmap with the characters and the respective hoppingdistances. <br>
a -> 1 <br>
b -> 2 <br>
c -> 3 <br>
... <br>
ß -> <br>
#### Method: setText & TextLength
The setText method is used to read the text which is stored in a specific .txt-file.
This is done with a BufferedReader and a FileReader. The content of this File is stored in a variable called input.
The While-function is used to iterate through each line of the file, until there is nothing left to read,
after that the BufferedReader is closed. After that the textLength is determined in the next method (TextLength)
#### Method: gameLoop
Moves each player individually and after each move the position of player1 or player2 is written into the 
respective array. In case the one player jumps out of the text, the hasIntersection Method will be called.
#### Method: hasIntersection
In the first part the two arrays, which do contain the positions will be compared and the intersections 
are going to be removed. If there are positions that were removed the length of one array will be changed.
We can use this for our advantage and compare the length of the original array with the length of the array 
in which some entries might have been removed. If both array lengths are the same we know that no entries have been removed 
and therefore there have been no intersections. 
If the arraylengths are not the same we know that there is somewhere a intersection and the intersection method will be called.
#### Method: intersection
This method takes the positionPlayer1Array and gets the last index of it. 
This index is the position from where on the intersection between player1 and player2 happened. 
This position is going to be marked in the original text with a '$' -character, because this word has to be changed 
in order to prevent a intersection. 

### Class: Game 
This class does everything that has to do we with the movement of each player.








The getJump.java contains a class getJump that defines a HashMap and two functions. The Function fillHashMap() fills the HashMap
with abc and it's values, that the getJumpF Functions need to return the Length of the next Jump as LengthOfJump. The getJumpF()
Function requires a character as parameter. It looks up the given character in the HashMap and returns it's value, that was set
by fillHashMap(). .The class structure is only temporary until we found a suitable solution for our project. !!!WorkInProgress!!!