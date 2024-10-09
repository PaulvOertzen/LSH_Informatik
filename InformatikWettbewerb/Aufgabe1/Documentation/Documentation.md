##Documentation
This File is for documenting our code and the changes we have applied to it. 

The setText method is used to read the text which is stored in a specific .txt-file. 
This is done with a BufferedReader and a FileReader. The content of this File is stored in a variable called input.
The While-function is used to iterate through each line of the file, until there is nothing left to read, 
after that the BufferedReader is closed.  

The Text class is used to output an edited .txt-file in case there is an intersection.
For specific Detail, please take a look at the respective class, as the documentation will
be worked out in Detail once this project is finished.

The getJump.java contains a class getJump that defines a HashMap and two functions. The Function fillHashMap() fills the HashMap
with abc and it's values, that the getJumpF Functions need to return the Length of the next Jump as LengthOfJump. The getJumpF()
Function requires a character as parameter. It looks up the given character in the HashMap and returns it's value, that was set
by fillHashMap(). .The class structure is only temporary until we found a suitable solution for our project. !!!WorkInProgress!!!