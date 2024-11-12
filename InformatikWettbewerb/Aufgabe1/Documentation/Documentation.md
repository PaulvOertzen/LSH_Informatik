# Documentation

## Task definition 
The task which we were given, stated that we should build a program that helps a person writing texts for a game 
in which two players jump through a text and who ever jumps out of the text first has won. 
The problem is, that in many cases there are so-called intersections, which means, that both players will jump out of text at same time.
Our solution for this problem is, that our program has two players that go through the text and if there is an intersection 
we would take the position of one player, go one move back and mark that position in the text with '$$$'-characters.
In case of an intersection we would go back one move and mark this in the text as word which needs to be changed, because 
this is the position from where on the following intersections happened. 

## Structure and Designdecisions 

1: We have decided to use as few comments as possible, since everything will be explained in this documentation. <br>

2: We have decided to use 4 classes, a class that does everything text-related, one that does everything player-related,
one that controls the two classes and of course the main class, which serves as entry-point for the compiler. 

3: We have tried a few algorithms to find intersections: <br>
3.1: Comparing the positions of each player after each move. This would have the advantage that you can stop the game as soon 
as there would be an intersection, however we will not be abler to detect time delayed intersections. A time delayed intersection 
is a intersection when two players jump over the exact same indexes, but not at the same time. For example: <br>
Player1: [0; 5; 7; 25; 37; ...] <br>
Player2: [1; 7; 25; 37; 45; ...] <br>
3.2: Due to the drawback of the first option, we decided to write every position into a individual Arraylist and then iterate 
through them, to find possible common entries. If there were two common entries the algorithm would go back to previous index (referring to the Arraylist index)
since this index was the cause for the intersection.


## Classes 
























## Variables  
In this section I will briefly explain all the variables.
As general rule, I defined alle the variables to the smallest scope possible.

### Globally defined variables

#### filepath 
A Variable that takes the absolute directory where the .txt file with its text is stored.
#### textString 
A variable that contains the text as a string, which the user want's to be analyzed.
#### intersection 
Specific point in text where an intersection happened. 
The Value of this variable is used to put a marking into the text.
#### stringIndexOutOfBounds
Is used to stop the game and continue with the next step, once the end of a given text is reached.
#### map
Contains the hoppingdistances for each character. Logically, the characters are the 'key'
#### player1Position / player2Position
Used to initialize the starting position's and track the positions throughout the game.
#### positionPlayer1Array / positionPlayer2Array
Each position is written into this array. Those positions are used to determine if there is 
an intersection or not.
#### rawtext 
Each line of text from the .txt file gets written in there and then passed 
into the rawtext variable and further on into textString and then returned to the globally 
defined variable
#### positionPlayer1ArrayLength
Contains the size of the Arraylist where the positions from player 1 get stored in
(Further explanation in "Methods")

### Locally defined variables 

#### startLocation
The current location of either Player1 or Player2, passed in as a parameter 
#### currentPositionChar
The character at a given position of a player. 
#### jumpWith
The jumpdistance, based on which character one player is currently at. 
#### reachedDestination 
Variable to check if a player has reached its intended index or not.
#### hopTargetIndex
The index where a player should go to
#### currentIndex
Index, where a player is currently at. This variable is used to check, if the character where the player 
is currently at, is a valid ASCI-charcater or not.  

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
...    <br>
ß -> 30 
#### Method: setText & TextLength
The setText method is used to read the text which is stored in a specific .txt-file.
This is done with a BufferedReader and a FileReader. The content of this File is stored in a variable called input.
The While-function is used to iterate through each line of the file, until there is nothing left to read,
after that the BufferedReader is closed. After that the textLength is determined in the next method (TextLength)
#### Method: gameLoop
Moves each player individually and after each move the position of player1 or player2 is written into the 
respective array. In case the one player jumps out of the text, the hasIntersection Method will be called.
#### Method: IntersectionCheck
In the first part the two arrays, which do contain the positions will be compared and the intersections 
are going to be removed. If there are positions that were removed the length of one array will be changed.
We can use this for our advantage and compare the length of the original array with the length of the array 
in which some entries might have been removed. If both array lengths are the same we know that no entries have been removed 
and therefore there have been no intersections. 
If the arraylengths are not the same we know that there is somewhere a intersection and the intersection method will be called.
#### Method: IntersectionPlace
This method takes the positionPlayer1Array and gets the last index of it. 
This index is the position from where on the intersection between player1 and player2 happened. 
This position is going to be marked in the original text with a '$' -character, because this word has to be changed 
in order to prevent a intersection. 

### Class: Game 
This class does everything that has to do we with the movement of each player.
#### Method: movePlayer
calls various methods to get the character at a specific position (index), decapitalize it and then look up the corresponding 
jumpdistance in the HashMap. After that, one individual player will be moved. 
#### Method: getChar
Gets passed in the current position as a parameter and then determines the character at this position (index). 
#### Method: decapitalizeChar
Decapitalizes the character from getChar, since we have only filled the HashMap with lower-case-characters, 
to save storage. 
#### Method: getJump
Gets the decapitalized character passed in as a parameter and then does look up the hashmap for the corresponding jumpdistance 
since the key is the character and the value is the jumpdistance. If this method gets passed in a charcter which is not a 
part of the alphabet (for example: ';' | ':' | '.' | ',' | etc...), the length of the jump will be 0. 
#### Method: hops
Does the hopping. This Method jumpes over each character individually and checks if it is a valid character, the targetindex will 
be incremented by 1 hence the hopdistance has to stay the same but the hopdistance of a non-valid-character is 0.
The hopping will be stopped, as soon as the player has reached its intended position. 
In case one of the players does jump out of the text, the game will be stopped for both players, because if one of players does 
jump aut of the text, this player has won, and the intersection-comparison will be done  in the checkIntersection Method 
in class TextManipulation.