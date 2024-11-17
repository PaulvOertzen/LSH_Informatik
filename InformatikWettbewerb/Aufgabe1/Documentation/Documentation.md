# Documentation

## Task definition 
The task which we were given, stated that we should build a program that helps a person writing texts for a game 
in which two players jump through a text and who ever jumps out of the text first has won. 
The problem is, that in many cases there are so-called intersections, which means, that both players will jump out of text at same time.
## Solution
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
as there would be an intersection, however we will not be able to detect time delayed intersections. A time delayed intersection 
is a intersection when two players jump over the exact same indexes, but not at the same time. For example: <br>
Player1: [0; 5; 7; 25; 37; ...] <br>
Player2: [1; 7; 25; 37; 45; ...] <br>
3.2: Due to the drawback of the first option, we decided to write every position into a individual Arraylist and then iterate 
through them, to find possible common entries. If there were two common entries the algorithm would go back to previous index (referring to the Arraylist index)
since this index was the cause for the intersection.


## Class Main 
This class does just serve as the entry-point for the compiler and only contains a instance of the Control class. <br>
This class contains no further methods.
## Class Control
As the name already says, this is the class which does control the two remaining classes and contains various algorithms to initialise
and fill the hashmap, take in the path of the inputtext, does move the players and check if there is an intersection or not.
### Method control 
Contains to method-calls for the remaining methods and also contains a instance of the TextManipulation class.
### Method filePath
This method uses a scanner to get the directory in which the user has stored it's .txt file which he wants to be analyzed.
The scanners input is assigned to the filepath variable.
### Method fillHashMap
This method fills the Hashmap, which is just simply called 'map', with the characters and the respective hoppingdistances. <br>
a -> 1 <br>
b -> 2 <br>
c -> 3 <br>
...    <br>
ß -> 30
### Method gameLoop
This method moves each player individually. This is done with a for-loop with !stringIndexOutOfBounds as condition.
As long as both players are within the bounds of the text, this variable set to false and will only be set to ture in case one does jump out of the text.
The positions of each player are stored in the player1Position and player2Position variables and after each move the current position will be written into an 
Arraylist (positionPlayer1Array and positionPlayer2Array). Once one player jumps out of the text, the intersectionCheck method will be called.
### Method intersectionCheck 
The check for an intersection is done with two nested for loops. The first for-loop takes one entry from the positionPlayer1Array at the index i 
and then compares it against all entries in the positionPlayer2Array. In case there is an intersection, meaning that one index from positionPlayer1Array
is equal to one index of positionPlayer2Array, we take the entry at i-1 from positionPlayer1Array, since this is the index from where on all the following intersections happened.
The value of the entry at i-1 will be assigned to the intersectionPlace variable and then passed in as a parameter in the TextOutput method, which the 
TextManipulation class contains. In case the Calculated intersection place, is <0, the intersectionplace variable will be set to 0 since there are no negative indexes.
## Class TextManipulation 
This class does everything text-related, that means that this class takes care of reading the .txt file which the user has specified 
and also takes care of exporting a new .txt file with the intersection marked in the text.
### Method setText
We are using a buffered reader to read the .txt file. As long as the text has a next line, this will be read.
The contence of one line will be assigned to the inputText variable and then passed into the rawText variable.
Once the process of reading the file is done, the contence of rawtext will be assigned to textString and then returned.
In case the user provides a invalid directory, he has the possibility to enter a valid directory.
### Method TextOutput
Gets passed in the place where a intersection happened as parameter and insterts three '$'-characters at this 
position. After that, the original file will overwritten, to make it easier for the user, since he does not need 
to search the output file.
## Class Game 
Does everything from getting the character at a specific position, calculating the jumplength and moving the players.
### Method movePlayer
Gets passed in the position of each player individually and then looks up the character by calling 
the getChar method, which does also decpitalize the characters.
Once those steps are done, the jumpwidth will be looked up in the Hashmap (Method getJump) and then finally 
moves the player.
### Method getChar
Gets passed in the current position and uses the textString to get the character at this position. 
The character will be assigned to a variable called characterAtPosition. 
### Method getJump
Contains a variable which is called lengthOfJump. It uses the Hashmap and the character characterAtPosition.
The character is the key and the jumpwidth is the corresponding value. 
### Method hops
Calculates the hopTargetIndex by adding the hopDistance and startlocation.
The currentindex contains the current position of one player. It gets incremented by 1 for each iteration.
For each iteration, the hopTargetIndex and currentIndex will be compared and if they are equal, meaning that the intended 
destination was reached, the hopping will be stopped. In case one player jumpes out of the text, the hopping will also be stopped. 
The method jumpes over each character individually and checks if it is a valid character or not. 
If a character is not valid, the hopTargetIndex will be incremented by one, since the hoppingdistance always has stay the same 
but the hoppingvalue is 0.